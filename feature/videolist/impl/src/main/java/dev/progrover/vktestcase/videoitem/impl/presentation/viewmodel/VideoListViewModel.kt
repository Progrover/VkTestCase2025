package dev.progrover.vktestcase.videoitem.impl.presentation.viewmodel

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.platovco.core.base.presentation.viewmodel.BaseViewModel
import dev.platovco.core.base.utils.JsonConverter
import dev.progrover.vktestcase.base.di.CoroutineQualifiers
import dev.progrover.vktestcase.videoitem.api.VideoModel
import dev.progrover.vktestcase.videoitem.impl.domain.interactor.VideoListInteractor
import dev.progrover.vktestcase.videoitem.impl.presentation.contract.VideoListUIEffect
import dev.progrover.vktestcase.videoitem.impl.presentation.contract.VideoListUIEvent
import dev.progrover.vktestcase.videoitem.impl.presentation.contract.VideoListUIState
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class VideoListViewModel @Inject constructor(
    @CoroutineQualifiers.DefaultCoroutineExceptionHandler
    private val coroutineExceptionHandler: CoroutineExceptionHandler,
    @CoroutineQualifiers.IoDispatcher
    private val ioDispatcher: CoroutineDispatcher,
    private val videolistInteractor: VideoListInteractor,
    private val jsonConverter: JsonConverter,
) : BaseViewModel<VideoListUIEvent, VideoListUIState, VideoListUIEffect>(VideoListUIState()) {

    init {
        getInfo()
    }

    override fun handleUIEvent(event: VideoListUIEvent) =
        when (event) {
            is VideoListUIEvent.OnVideoClick ->
                handleOnVideoClick(event.title)
        }

    private fun getInfo() {
        setState(currentState.copy(isLoading = true))
        viewModelScope.launch(coroutineExceptionHandler + ioDispatcher) {

            val videos = videolistInteractor.getVideos()
            setState(currentState.copy(isLoading = true, videos = videos))
        }
    }

    private fun handleOnVideoClick(title: String) {
        val video = currentState.videos.firstOrNull { it.title == title }
        val json = jsonConverter.toJson(video!!, VideoModel::class.java)
        setEffect(VideoListUIEffect.NavigateToVideoItemScreen(json))
    }
}
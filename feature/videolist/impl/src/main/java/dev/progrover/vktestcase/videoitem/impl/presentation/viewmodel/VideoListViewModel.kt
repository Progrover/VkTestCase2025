package dev.progrover.vktestcase.videoitem.impl.presentation.viewmodel

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.platovco.core.base.presentation.viewmodel.BaseViewModel
import dev.progrover.vktestcase.base.data.storage.Prefs
import dev.progrover.vktestcase.base.di.CoroutineQualifiers
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
    private val prefs: Prefs,
) : BaseViewModel<VideoListUIEvent, VideoListUIState, VideoListUIEffect>(VideoListUIState()) {

    init {
        getInfo()
    }

    override fun handleUIEvent(event: VideoListUIEvent) =
        when (event) {
            is VideoListUIEvent.OnVideoClick -> TODO()
        }

    private fun getInfo() {
        setState(currentState.copy(isLoading = true))
        viewModelScope.launch(coroutineExceptionHandler + ioDispatcher) {

            val videos = videolistInteractor.getVideos()
            setState(currentState.copy(isLoading = true, videos = videos))
        }
    }
}
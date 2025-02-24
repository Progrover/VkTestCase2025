package dev.progrover.vktestcase.videoitem.impl.presentation.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.platovco.core.base.presentation.viewmodel.BaseViewModel
import dev.platovco.core.base.utils.JsonConverter
import dev.progrover.vktestcase.base.di.CoroutineQualifiers
import dev.progrover.vktestcase.videoitem.api.VideoModel
import dev.progrover.vktestcase.videoitem.impl.presentation.contract.VideoItemUIEffect
import dev.progrover.vktestcase.videoitem.impl.presentation.contract.VideoItemUIEvent
import dev.progrover.vktestcase.videoitem.impl.presentation.contract.VideoItemUIState
import dev.progrover.vktestcase.videoitem.impl.presentation.navigation.VideoListNavigationFactory.Companion.ARG_VIDEO
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class VideoItemViewModel @Inject constructor(
    @CoroutineQualifiers.DefaultCoroutineExceptionHandler
    private val coroutineExceptionHandler: CoroutineExceptionHandler,
    @CoroutineQualifiers.IoDispatcher
    private val ioDispatcher: CoroutineDispatcher,
    private val savedStateHandle: SavedStateHandle,
    private val jsonConverter: JsonConverter,
) : BaseViewModel<VideoItemUIEvent, VideoItemUIState, VideoItemUIEffect>(VideoItemUIState()) {

    private val videoJson: String? = savedStateHandle[ARG_VIDEO]

    init {
        getInfo()
    }

    override fun handleUIEvent(event: VideoItemUIEvent) =
        when (event) {
            VideoItemUIEvent.NavigateBack ->
                setEffect(VideoItemUIEffect.NavigateBack)
        }

    private fun getInfo() {
        setState(currentState.copy(isLoading = true))
        viewModelScope.launch(coroutineExceptionHandler + ioDispatcher) {

            val video = jsonConverter.fromJson(videoJson!!, VideoModel::class.java, null)
            setState(currentState.copy(isLoading = false, video = video))
        }
    }
}
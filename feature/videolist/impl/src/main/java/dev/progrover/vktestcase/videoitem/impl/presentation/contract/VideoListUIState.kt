package dev.progrover.vktestcase.videoitem.impl.presentation.contract

import dev.platovco.core.base.presentation.mvi.UIState
import dev.progrover.vktestcase.videoitem.api.VideoModel

data class VideoListUIState(
    val isLoading: Boolean = false,
    val internetError: Boolean = false,
    val videos: List<VideoModel> = emptyList(),
) : UIState
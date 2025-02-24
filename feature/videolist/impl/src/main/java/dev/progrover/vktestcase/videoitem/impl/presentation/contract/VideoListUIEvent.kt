package dev.progrover.vktestcase.videoitem.impl.presentation.contract

import dev.platovco.core.base.presentation.mvi.UIEvent

sealed class VideoListUIEvent : UIEvent {

    data class OnVideoClick(val title: String) : VideoListUIEvent()
}
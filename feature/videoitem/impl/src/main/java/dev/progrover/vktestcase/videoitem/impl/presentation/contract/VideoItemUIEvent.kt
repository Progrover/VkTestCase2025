package dev.progrover.vktestcase.videoitem.impl.presentation.contract

import dev.platovco.core.base.presentation.mvi.UIEvent

sealed class VideoItemUIEvent : UIEvent {

    data object NavigateBack: VideoItemUIEvent()
}
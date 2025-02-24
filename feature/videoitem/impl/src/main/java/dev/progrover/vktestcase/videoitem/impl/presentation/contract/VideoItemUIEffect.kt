package dev.progrover.vktestcase.videoitem.impl.presentation.contract

import androidx.annotation.StringRes
import dev.platovco.core.base.presentation.mvi.UIEffect

sealed class VideoItemUIEffect : UIEffect {

    class ShowError(@StringRes val messageResId: Int) : VideoItemUIEffect()
    data object NavigateBack : VideoItemUIEffect()
}
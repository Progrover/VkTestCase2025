package dev.progrover.vktestcase.videoitem.impl.presentation.contract

import androidx.annotation.StringRes
import dev.platovco.core.base.presentation.mvi.UIEffect

sealed class VideoListUIEffect : UIEffect {

    class ShowError(@StringRes val messageResId: Int) : VideoListUIEffect()
    class NavigateToVideoItemScreen(val videoJson: String) : VideoListUIEffect()
}
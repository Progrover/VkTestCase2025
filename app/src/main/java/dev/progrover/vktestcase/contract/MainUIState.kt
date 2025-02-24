package dev.progrover.vktestcase.contract

import dev.platovco.core.base.presentation.mvi.UIState


data class MainUIState(
    val isBottomNavigationBarVisible: Boolean = true,
) : UIState
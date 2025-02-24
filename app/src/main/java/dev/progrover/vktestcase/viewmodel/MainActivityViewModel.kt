package dev.progrover.vktestcase.viewmodel


import dagger.hilt.android.lifecycle.HiltViewModel
import dev.platovco.core.base.presentation.viewmodel.BaseViewModel
import dev.progrover.vktestcase.base.di.CoroutineQualifiers
import dev.progrover.vktestcase.contract.MainUIEffect
import dev.progrover.vktestcase.contract.MainUIEvent
import dev.progrover.vktestcase.contract.MainUIState
import kotlinx.coroutines.CoroutineExceptionHandler
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    @CoroutineQualifiers.DefaultCoroutineExceptionHandler
    private val coroutineExceptionHandler: CoroutineExceptionHandler,

    ) : BaseViewModel<MainUIEvent, MainUIState, MainUIEffect>(MainUIState()) {

    override fun handleUIEvent(event: MainUIEvent) {

    }
}
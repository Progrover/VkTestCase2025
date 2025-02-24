package dev.progrover.vktestcase.videoitem.impl.presentation.screen

import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import dev.progrover.vktestcase.videoitem.impl.presentation.components.screencontent.VideoItemScreenContent
import dev.progrover.vktestcase.videoitem.impl.presentation.contract.VideoItemUIEffect
import dev.progrover.vktestcase.videoitem.impl.presentation.viewmodel.VideoItemViewModel
import kotlinx.coroutines.flow.collectLatest

@Composable
internal fun VideoItemScreen(
    navController: NavController,
    viewModel: VideoItemViewModel,
) {

    val context = LocalContext.current
    val uiState by viewModel.uiState.collectAsState()
    val snackbarHostState = remember { SnackbarHostState() }

    LaunchedEffect(key1 = viewModel.effect) {
        viewModel.effect.collectLatest { effect ->
            when (effect) {

                is VideoItemUIEffect.ShowError ->
                    snackbarHostState.showSnackbar(
                        message = context.getString(effect.messageResId),
                        withDismissAction = true,
                        duration = SnackbarDuration.Short
                    )

                is VideoItemUIEffect.NavigateBack ->
                    navController.popBackStack()
            }
        }
    }

    VideoItemScreenContent(
        modifier = Modifier,
        uiState = uiState,
        onEvent = viewModel::setEvent,
        snackbarHostState = snackbarHostState,
    )
}
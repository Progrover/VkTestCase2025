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
import dev.progrover.vktestcase.videoitem.impl.presentation.components.screencontent.VideoListScreenContent
import dev.progrover.vktestcase.videoitem.impl.presentation.contract.VideoListUIEffect
import dev.progrover.vktestcase.videoitem.impl.presentation.viewmodel.VideoListViewModel
import kotlinx.coroutines.flow.collectLatest

@Composable
internal fun VideoListScreen(
    navController: NavController,
    viewModel: VideoListViewModel,
) {

    val context = LocalContext.current
    val uiState by viewModel.uiState.collectAsState()
    val snackbarHostState = remember { SnackbarHostState() }

    LaunchedEffect(key1 = viewModel.effect) {
        viewModel.effect.collectLatest { effect ->
            when (effect) {

                is VideoListUIEffect.ShowError ->
                    snackbarHostState.showSnackbar(
                        message = context.getString(effect.messageResId),
                        withDismissAction = true,
                        duration = SnackbarDuration.Short
                    )

                is VideoListUIEffect.NavigateToVideoItemScreen -> TODO()
            }
        }
    }

    VideoListScreenContent(
        modifier = Modifier,
        uiState = uiState,
        onEvent = viewModel::setEvent,
        snackbarHostState = snackbarHostState,
    )
}
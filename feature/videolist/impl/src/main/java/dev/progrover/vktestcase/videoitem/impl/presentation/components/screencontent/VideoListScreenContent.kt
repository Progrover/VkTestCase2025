package dev.progrover.vktestcase.videoitem.impl.presentation.components.screencontent

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import dev.progrover.vktestcase.theme.AppTheme
import dev.progrover.vktestcase.uicommon.views.LoadingScreenPlaceHolder
import dev.progrover.vktestcase.videoitem.impl.presentation.contract.VideoListUIEvent
import dev.progrover.vktestcase.videoitem.impl.presentation.contract.VideoListUIState

@Composable
internal fun VideoListScreenContent(
    modifier: Modifier,
    uiState: VideoListUIState,
    onEvent: (VideoListUIEvent) -> Unit,
    snackbarHostState: SnackbarHostState,
) {

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(AppTheme.colors.background),
    ) {

        if (!uiState.isLoading) {

        } else {
            LoadingScreenPlaceHolder(Modifier, true)
        }


        SnackbarHost(
            modifier = Modifier
                .navigationBarsPadding()
                .padding(AppTheme.paddings.paddingX3)
                .align(Alignment.BottomCenter),
            hostState = snackbarHostState,
        )
    }
}

@Composable
@Preview(showBackground = true)
private fun VideoListScreenContentPreview() =
    VideoListScreenContent(
        modifier = Modifier,
        uiState = VideoListUIState(),
        onEvent = {},
        snackbarHostState = SnackbarHostState(),
    )
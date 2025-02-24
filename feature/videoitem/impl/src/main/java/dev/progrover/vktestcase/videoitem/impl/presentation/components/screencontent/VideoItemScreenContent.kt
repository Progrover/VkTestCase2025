package dev.progrover.vktestcase.videoitem.impl.presentation.components.screencontent

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView
import dev.progrover.vktestcase.theme.AppTheme
import dev.progrover.vktestcase.uicommon.views.LoadingScreenPlaceHolder
import dev.progrover.vktestcase.videoitem.impl.presentation.contract.VideoItemUIEvent
import dev.progrover.vktestcase.videoitem.impl.presentation.contract.VideoItemUIState

@Composable
internal fun VideoItemScreenContent(
    modifier: Modifier,
    uiState: VideoItemUIState,
    onEvent: (VideoItemUIEvent) -> Unit,
    snackbarHostState: SnackbarHostState,
) {

    val context = LocalContext.current
    val player = remember { ExoPlayer.Builder(context).build() }
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(AppTheme.colors.background),
    ) {

        if (!uiState.isLoading) {

            DisposableEffect(Unit) {
                val mediaItem =
                    MediaItem.fromUri("https://drive.google.com/uc?export=download&id=${uiState.video!!.id}")
                player.setMediaItem(mediaItem)
                player.prepare()
                player.playWhenReady = true

                onDispose {
                    player.release()
                }
            }

            Box(modifier = Modifier.fillMaxSize()) {
                AndroidView(
                    factory = { ctx ->
                        PlayerView(ctx).apply {
                            this.player = player
                            useController = true // Включаем управление
                        }
                    },
                    modifier = Modifier.fillMaxSize()
                )
            }
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
    VideoItemScreenContent(
        modifier = Modifier,
        uiState = VideoItemUIState(),
        onEvent = {},
        snackbarHostState = SnackbarHostState(),
    )
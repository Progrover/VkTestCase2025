package dev.progrover.vktestcase.videoitem.impl.presentation.components.screencontent

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import dev.progrover.vktestcase.theme.AppTheme
import dev.progrover.vktestcase.videoitem.api.VideoModel

@Composable
internal fun VideoCard(
    modifier: Modifier,
    video: VideoModel,
    onClick: () -> Unit,
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable(onClick = onClick),
        shape = RoundedCornerShape(12.dp),
    ) {
        Row(modifier = Modifier.padding(8.dp)) {
            AsyncImage(
                model = video.getThumbnailUrl(),
                contentDescription = "Thumbnail",
                modifier = Modifier
                    .size(100.dp)
                    .clip(RoundedCornerShape(8.dp))
            )

            Spacer(modifier = Modifier.width(8.dp))

            Column {
                Text(text = video.title, style = AppTheme.typography.h_32)
                Text(
                    text = "Длительность: ${video.getDuration()}",
                    style = AppTheme.typography.text_18_medium
                )
            }
        }
    }
}
package dev.progrover.vktestcase.videoitem.api

import androidx.compose.runtime.Immutable

@Immutable
data class VideoModel(
    val id: String,
    val title: String,
    val mimeType: String,
    val durationMillis: Long?,
) {
    fun getThumbnailUrl(): String {
        return "https://drive.google.com/thumbnail?id=$id"
    }

    fun getDuration(): String {
        durationMillis?.let {
            val seconds = it / 1000 % 60
            val minutes = it / (1000 * 60) % 60
            val hours = it / (1000 * 60 * 60)
            return if (hours > 0) {
                String.format("%02d:%02d:%02d", hours, minutes, seconds)
            } else {
                String.format("%02d:%02d", minutes, seconds)
            }
        }
        return "Неизвестно"
    }
}
package dev.progrover.vktestcase.videoitem.impl.domain.repository

import dev.progrover.vktestcase.videoitem.api.VideoModel

interface VideoListRepository {

    suspend fun getVideos(): List<VideoModel>
}
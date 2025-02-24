package dev.progrover.vktestcase.videoitem.impl.domain.interactor

import dev.progrover.vktestcase.videoitem.api.VideoModel

interface VideoListInteractor {

    suspend fun getVideos() : List<VideoModel>
}
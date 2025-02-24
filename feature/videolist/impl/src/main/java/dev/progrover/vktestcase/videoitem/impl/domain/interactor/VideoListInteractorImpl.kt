package dev.progrover.vktestcase.videoitem.impl.domain.interactor

import dev.progrover.vktestcase.videoitem.impl.domain.repository.VideoListRepository
import javax.inject.Inject

class VideoListInteractorImpl @Inject constructor(
    private val repository: VideoListRepository,
) : VideoListInteractor {
    override suspend fun getVideos() =
        repository.getVideos()
}
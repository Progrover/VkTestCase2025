package dev.progrover.vktestcase.videoitem.impl.data.repository

import dev.progrover.vktestcase.base.data.repository.BaseRepository
import dev.progrover.vktestcase.videoitem.api.VideoModel
import dev.progrover.vktestcase.videoitem.impl.data.api.VideoListApi
import dev.progrover.vktestcase.videoitem.impl.domain.repository.VideoListRepository
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class VideoListRepositoryImpl @Inject constructor(
    private val api: VideoListApi,
) : VideoListRepository, BaseRepository(Dispatchers.IO) {


    companion object {
        private const val FOLDER_ID = "15bq6fDBkvBIBpusIisA2c5cPqOs_5Ydn"
        private const val API_KEY = "AIzaSyDQ6MkhXV4PLuORDBPmLpBTSDF9rJkOGLg"
    }

    override suspend fun getVideos(): List<VideoModel> =
        executeOnIO {
            val query = "'$FOLDER_ID' in parents and mimeType contains 'video/'"
            return@executeOnIO try {
                val response = api.getVideos(query, API_KEY)
                response.files
            } catch (e: Exception) {
                emptyList()
            }
        }
}
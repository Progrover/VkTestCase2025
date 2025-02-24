package dev.progrover.vktestcase.videoitem.impl.data.api

import dev.progrover.vktestcase.videoitem.impl.data.model.VideoResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface VideoListApi {
    @GET("drive/v3/files")
    suspend fun getVideos(
        @Query("q") query: String,
        @Query("key") apiKey: String,
        @Query("fields") fields: String = "files(id,name,mimeType,videoMediaMetadata(durationMillis))"
    ): VideoResponse
}
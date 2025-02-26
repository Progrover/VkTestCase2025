package dev.progrover.vktestcase.videoitem.impl.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.progrover.vktestcase.videoitem.impl.data.api.VideoListApi
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    @Singleton
    fun provideVideoListApi(
        retrofit: Retrofit,
    ): VideoListApi =
        retrofit.create(VideoListApi::class.java)
}
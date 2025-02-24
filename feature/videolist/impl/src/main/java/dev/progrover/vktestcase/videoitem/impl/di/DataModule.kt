package dev.progrover.vktestcase.videoitem.impl.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.progrover.vktestcase.videoitem.impl.data.mapper.VideoListDTOMapper
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    @Singleton
    fun provideVideoListMapper(): VideoListDTOMapper = VideoListDTOMapper()
}
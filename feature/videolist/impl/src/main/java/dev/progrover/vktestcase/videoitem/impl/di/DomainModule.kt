package dev.progrover.vktestcase.videoitem.impl.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.progrover.vktestcase.videoitem.impl.domain.interactor.VideoListInteractor
import dev.progrover.vktestcase.videoitem.impl.domain.interactor.VideoListInteractorImpl
import dev.progrover.vktestcase.videoitem.impl.data.api.VideoListApi
import dev.progrover.vktestcase.videoitem.impl.data.mapper.VideoListDTOMapper
import dev.progrover.vktestcase.videoitem.impl.data.repository.VideoListRepositoryImpl
import dev.progrover.vktestcase.videoitem.impl.domain.repository.VideoListRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DomainModule {

    @Provides
    @Singleton
    fun provideVideoListRepository(
        api: VideoListApi,
    ): VideoListRepository =
        VideoListRepositoryImpl(
            api
        )

    @Provides
    @Singleton
    fun provideVideoListInteractor(
        repository: VideoListRepository,
    ): VideoListInteractor =
        VideoListInteractorImpl(
            repository = repository,
        )
}
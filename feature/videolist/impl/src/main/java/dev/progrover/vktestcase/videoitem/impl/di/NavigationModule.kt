package dev.progrover.vktestcase.videoitem.impl.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoSet
import dev.progrover.vktestcase.base.navigation.NavigationFactory
import dev.progrover.vktestcase.videoitem.impl.presentation.navigation.VideoListNavigationFactory
import dev.progrover.vktestcase.base.di.NavigationFactoryQualifiers
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal interface NavigationModule {

    @Singleton
    @Binds
    @IntoSet
    @NavigationFactoryQualifiers.MainActivity
    fun bindVideoListNavigationFactory(factory: VideoListNavigationFactory): NavigationFactory
}
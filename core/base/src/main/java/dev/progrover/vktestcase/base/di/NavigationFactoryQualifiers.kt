package dev.progrover.vktestcase.base.di

import javax.inject.Qualifier

interface NavigationFactoryQualifiers {

    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class MainActivity
}
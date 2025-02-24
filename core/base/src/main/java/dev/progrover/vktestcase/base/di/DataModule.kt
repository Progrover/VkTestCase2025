package dev.progrover.vktestcase.base.di

import android.app.Application
import android.content.ContentResolver
import android.content.Context
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import dev.progrover.vktestcase.base.data.storage.Prefs
import dev.progrover.vktestcase.base.data.storage.SharedPrefs
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    @Singleton
    fun provideContentResolver(
        @ApplicationContext context: Context,
    ): ContentResolver =
        context.contentResolver

    @Provides
    @Singleton
    fun provideSharedPrefs(
        application: Application,
        moshi: Moshi
    ): Prefs =
        SharedPrefs(
            application = application,
            prefsName = "cookiePrefs",
            moshi = moshi
        )
}
package com.mirea.laba2.di.module

import android.app.Application
import android.content.Context
import com.mirea.laba2.BuildConfig
import com.mirea.laba2.data.preferences.PreferencesManager
import com.mirea.laba2.data.preferences.PreferencesManagerImpl
import com.mirea.laba2.di.qualifier.PreferencesInfo
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [NetworkModule::class])
open class ApplicationModule {

    @Provides
    @Singleton
    fun provideContext(application: Application): Context = application

    @Provides
    @PreferencesInfo
    fun providePrefFileName(): String = BuildConfig.PREF_NAME

    @Provides
    @Singleton
    fun providePrefHelper(preferences: PreferencesManagerImpl): PreferencesManager = preferences

}
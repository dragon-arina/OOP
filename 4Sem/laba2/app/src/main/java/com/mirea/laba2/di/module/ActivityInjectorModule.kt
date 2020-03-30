package com.mirea.laba2.di.module

import com.mirea.laba2.di.scope.AppActivityScope
import com.mirea.laba2.ui.main.MainActivity
import com.mirea.laba2.ui.main.MainActivityModule
import com.mirea.laba2.ui.splash.SplashActivity
import com.mirea.laba2.ui.splash.SplashActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityInjectorModule {

    @AppActivityScope
    @ContributesAndroidInjector(modules = [SplashActivityModule::class])
    internal abstract fun contributeSplashActivity(): SplashActivity

    @AppActivityScope
    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    internal abstract fun contributeMainActivity(): MainActivity

}
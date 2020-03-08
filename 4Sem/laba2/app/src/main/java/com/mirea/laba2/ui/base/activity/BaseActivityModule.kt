package com.mirea.laba2.ui.base.activity

import android.content.Context
import android.view.View
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import com.mirea.laba2.di.scope.AppActivityScope
import dagger.Module
import dagger.Provides

@Module
class BaseActivityModule {


    @Provides
    @AppActivityScope
    internal fun provideContext(activity: BaseActivity): Context = activity

    @Provides
    @AppActivityScope
    internal fun provideView(activity: BaseActivity): View = activity.root

    @Provides
    @AppActivityScope
    internal fun provideFragmentManager(activity: BaseActivity): FragmentManager = activity.supportFragmentManager

    @Provides
    @AppActivityScope
    internal fun provideLifecycle(activity: BaseActivity): Lifecycle = activity.lifecycle

    @Provides
    @AppActivityScope
    internal fun provideLifecycleOwner(activity: BaseActivity): LifecycleOwner = activity

}
package com.mirea.laba2.ui.base.fragment

import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import com.mirea.laba2.di.qualifier.FragmentContext
import dagger.Module
import dagger.Provides

@Module
class BaseFragmentModule {

    @Provides
    @FragmentContext
    internal fun provideFragmentManager(fragment: BaseFragment): FragmentManager = fragment.childFragmentManager

    @Provides
    @FragmentContext
    internal fun provideLifecycle(fragment: BaseFragment): Lifecycle = fragment.lifecycle

}
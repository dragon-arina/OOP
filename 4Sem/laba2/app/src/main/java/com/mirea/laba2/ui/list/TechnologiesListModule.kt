package com.mirea.laba2.ui.list

import com.mirea.laba2.ui.base.fragment.BaseFragment
import com.mirea.laba2.ui.base.fragment.BaseFragmentModule
import dagger.Module
import dagger.Provides
import javax.inject.Scope

@Module(includes = [BaseFragmentModule::class])
abstract class TechnologiesListModule {

    @Module
    companion object {
        @Provides
        @JvmStatic
        @ModuleScope
        fun provideViewModel(impl: TechnologiesListViewModelImpl): TechnologiesListViewModel = impl

        @Provides
        @ModuleScope
        @JvmStatic
        fun provideBaseFragment(fragment: TechnologiesListFragment): BaseFragment = fragment
    }

    @Scope
    @kotlin.annotation.MustBeDocumented
    @kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
    annotation class ModuleScope

}
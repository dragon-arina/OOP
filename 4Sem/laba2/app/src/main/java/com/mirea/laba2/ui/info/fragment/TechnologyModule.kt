package com.mirea.laba2.ui.info.fragment

import com.mirea.laba2.ui.base.fragment.BaseFragment
import com.mirea.laba2.ui.base.fragment.BaseFragmentModule
import dagger.Module
import dagger.Provides
import javax.inject.Scope

@Module(includes = [BaseFragmentModule::class])
abstract class TechnologyModule {

    @Module
    companion object {
        @Provides
        @JvmStatic
        @ModuleScope
        fun provideViewModel(impl: TechnologyViewModelImpl): TechnologyViewModel = impl

        @Provides
        @ModuleScope
        @JvmStatic
        fun provideBaseFragment(fragment: TechnologyFragment): BaseFragment = fragment
    }

    @Scope
    @kotlin.annotation.MustBeDocumented
    @kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
    annotation class ModuleScope

}
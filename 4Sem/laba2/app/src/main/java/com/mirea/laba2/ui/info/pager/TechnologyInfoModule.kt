package com.mirea.laba2.ui.info.pager

import com.mirea.laba2.ui.base.fragment.BaseFragment
import com.mirea.laba2.ui.base.fragment.BaseFragmentModule
import dagger.Module
import dagger.Provides
import javax.inject.Scope

@Module(includes = [BaseFragmentModule::class])
abstract class TechnologyInfoModule {

    @Module
    companion object {
        @Provides
        @JvmStatic
        @ModuleScope
        fun provideViewModel(impl: TechnologyInfoViewModelImpl): TechnologyInfoViewModel = impl

        @Provides
        @ModuleScope
        @JvmStatic
        fun provideBaseFragment(fragment: TechnologyInfoFragment): BaseFragment = fragment
    }

    @Scope
    @kotlin.annotation.MustBeDocumented
    @kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
    annotation class ModuleScope

}
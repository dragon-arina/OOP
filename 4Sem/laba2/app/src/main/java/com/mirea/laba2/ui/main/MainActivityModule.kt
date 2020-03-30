package com.mirea.laba2.ui.main

import androidx.databinding.DataBindingUtil
import com.mirea.laba2.databinding.ActivityMainBinding
import com.mirea.laba2.di.module.FragmentInjectorModule
import com.mirea.laba2.di.scope.AppActivityScope
import com.mirea.laba2.ui.base.activity.BaseActivity
import com.mirea.laba2.ui.base.activity.BaseActivityModule
import com.mirea.laba2.ui.info.fragment.TechnologyFragment
import com.mirea.laba2.ui.info.fragment.TechnologyModule
import com.mirea.laba2.ui.info.pager.TechnologyInfoFragment
import com.mirea.laba2.ui.info.pager.TechnologyInfoModule
import com.mirea.laba2.ui.list.TechnologiesListFragment
import com.mirea.laba2.ui.list.TechnologiesListModule
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector

@Module(includes = [BaseActivityModule::class, FragmentInjectorModule::class])
abstract class MainActivityModule {

    @Module
    companion object {
        @Provides
        @JvmStatic
        @AppActivityScope
        fun provideBaseActivity(activity: MainActivity): BaseActivity = activity

        @Provides
        @JvmStatic
        @AppActivityScope
        fun provideViewModel(impl: MainViewModelImpl): MainViewModel = impl

        @Provides
        @AppActivityScope
        @JvmStatic
        fun provideBinding(activity: MainActivity,
                           viewModel: MainViewModel): ActivityMainBinding =
            DataBindingUtil.bind<ActivityMainBinding>(activity.root)!!.apply {
                this.viewmodel = viewModel
                this.lifecycleOwner = activity
            }
    }

    @TechnologiesListModule.ModuleScope
    @ContributesAndroidInjector(modules = [TechnologiesListModule::class])
    abstract fun contributeTechnologiesListFragment(): TechnologiesListFragment

    @TechnologyInfoModule.ModuleScope
    @ContributesAndroidInjector(modules = [TechnologyInfoModule::class])
    abstract fun contributeTechnologyInfoFragment(): TechnologyInfoFragment

    @TechnologyModule.ModuleScope
    @ContributesAndroidInjector(modules = [TechnologyModule::class])
    abstract fun contributeTechnologyFragment(): TechnologyFragment

}
package com.mirea.laba2.ui.splash

import androidx.databinding.DataBindingUtil
import com.mirea.laba2.databinding.ActivitySplashBinding
import com.mirea.laba2.di.module.FragmentInjectorModule
import com.mirea.laba2.di.scope.AppActivityScope
import com.mirea.laba2.ui.base.activity.BaseActivity
import com.mirea.laba2.ui.base.activity.BaseActivityModule
import dagger.Module
import dagger.Provides

@Module(includes = [BaseActivityModule::class, FragmentInjectorModule::class])
abstract class SplashActivityModule {

    @Module
    companion object {

        @Provides
        @JvmStatic
        @AppActivityScope
        fun provideBaseActivity(activity: SplashActivity): BaseActivity = activity

        @Provides
        @JvmStatic
        @AppActivityScope
        fun provideViewModel(impl: SplashViewModelImpl): SplashViewModel = impl

        @Provides
        @JvmStatic
        @AppActivityScope
        fun provideBinding(activity: SplashActivity,
                           viewModel: SplashViewModel
        ): ActivitySplashBinding =
            DataBindingUtil.bind<ActivitySplashBinding>(activity.root)!!.apply {
                this.viewmodel = viewModel
                this.lifecycleOwner = activity
            }

    }

}
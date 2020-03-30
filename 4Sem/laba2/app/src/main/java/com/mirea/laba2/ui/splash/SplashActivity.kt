package com.mirea.laba2.ui.splash

import androidx.lifecycle.observe
import com.mirea.laba2.R
import com.mirea.laba2.databinding.ActivitySplashBinding
import com.mirea.laba2.ui.base.activity.BaseActivity
import com.mirea.laba2.util.navigator.Navigator
import dagger.Lazy
import javax.inject.Inject

class SplashActivity: BaseActivity(R.layout.activity_splash) {

    @Inject
    override
    lateinit var binding: Lazy<ActivitySplashBinding>

    @Inject
    lateinit var navigator: Navigator

    override fun onStart() {
        super.onStart()
        binding.get().viewmodel?.data?.observe (this) { data -> navigator.openMainScreen(data) }
    }

}
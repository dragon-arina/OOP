package com.mirea.laba2.ui.splash

import androidx.lifecycle.LiveData
import com.mirea.laba2.data.network.response.MainScreenListResponse

interface SplashViewModel {
    val data: LiveData<List<MainScreenListResponse>>
    val loading: LiveData<Boolean>
    fun loadList()
}
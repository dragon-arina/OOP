package com.mirea.laba2.ui.splash

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.viewModelScope
import com.mirea.laba2.data.network.repository.ApiRepository
import com.mirea.laba2.ui.base.viewmodel.BaseViewModelSimple
import kotlinx.coroutines.launch
import javax.inject.Inject

class SplashViewModelImpl @Inject constructor(
    lifecycle: Lifecycle,
    private val repository: ApiRepository
): SplashViewModel, BaseViewModelSimple(lifecycle) {

    override fun onStart() {
        super.onStart()
        viewModelScope.launch {
            runCatching {
            repository.getMainScreenList()
            }.onSuccess {

            }.onFailure { t ->
                t.printStackTrace()
            }
        }
    }

}
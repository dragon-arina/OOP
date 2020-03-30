package com.mirea.laba2.ui.splash

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.mirea.laba2.data.network.repository.ApiRepository
import com.mirea.laba2.data.network.response.MainScreenListResponse
import com.mirea.laba2.ui.base.viewmodel.BaseViewModelSimple
import kotlinx.coroutines.launch
import javax.inject.Inject

class SplashViewModelImpl @Inject constructor(
    lifecycle: Lifecycle,
    private val repository: ApiRepository
): SplashViewModel, BaseViewModelSimple(lifecycle) {

    override val data = MutableLiveData<List<MainScreenListResponse>>()

    override val loading = MutableLiveData<Boolean>()

    override fun onStart() {
        super.onStart()
        loadList()
    }

    override fun loadList() {
        loading.postValue(true)
        viewModelScope.launch {
            runCatching {
                repository.getMainScreenList()
            }.onSuccess { response ->
                data.postValue(response.filter { item -> item.name != null })
            }.onFailure { t ->
                loading.postValue(false)
                t.printStackTrace()
            }
        }
    }

}
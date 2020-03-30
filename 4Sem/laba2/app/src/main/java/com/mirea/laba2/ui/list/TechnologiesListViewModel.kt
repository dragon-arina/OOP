package com.mirea.laba2.ui.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.mirea.laba2.data.network.response.MainScreenListResponse
import com.mirea.laba2.ui.base.viewmodel.BaseViewModelSimple

interface TechnologiesListViewModel {

    val items: MutableLiveData<List<MainScreenListResponse>>

}
package com.mirea.laba2.ui.info.fragment

import androidx.lifecycle.MutableLiveData
import com.mirea.laba2.data.network.response.MainScreenListResponse

interface TechnologyViewModel {

    val item: MutableLiveData<MainScreenListResponse>

}
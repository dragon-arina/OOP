package com.mirea.laba2.ui.info.fragment

import androidx.lifecycle.MutableLiveData
import com.mirea.laba2.data.network.response.MainScreenListResponse
import javax.inject.Inject

class TechnologyViewModelImpl @Inject constructor(): TechnologyViewModel {

    override val item = MutableLiveData<MainScreenListResponse>()

}
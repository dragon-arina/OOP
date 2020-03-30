package com.mirea.laba2.ui.info.pager

import androidx.lifecycle.MutableLiveData
import com.mirea.laba2.ui.base.viewmodel.BaseViewModel
import javax.inject.Inject

class TechnologyInfoViewModelImpl @Inject constructor() : BaseViewModel(), TechnologyInfoViewModel {

    override val adapter = MutableLiveData<ViewPagerAdapter>()

    override val currentItem = MutableLiveData<Int>()

}
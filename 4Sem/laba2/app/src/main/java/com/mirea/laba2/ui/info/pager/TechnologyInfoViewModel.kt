package com.mirea.laba2.ui.info.pager

import androidx.lifecycle.MutableLiveData

interface TechnologyInfoViewModel {

    val adapter: MutableLiveData<ViewPagerAdapter>
    val currentItem: MutableLiveData<Int>

}
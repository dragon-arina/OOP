package com.mirea.laba2.util.navigator

import com.mirea.laba2.data.network.response.MainScreenListResponse

interface Navigator {
    fun openMainScreen(data: List<MainScreenListResponse>)
}
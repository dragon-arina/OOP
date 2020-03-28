package com.mirea.laba2.data.network

import com.mirea.laba2.data.network.response.MainScreenListResponse

interface Api {

    suspend fun loadListForMainScreen(): List<MainScreenListResponse>

}
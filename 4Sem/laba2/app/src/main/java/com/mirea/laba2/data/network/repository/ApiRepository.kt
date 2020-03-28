package com.mirea.laba2.data.network.repository

import com.mirea.laba2.data.network.Api
import javax.inject.Inject

class ApiRepository @Inject constructor(private val api: Api) {
    suspend fun getMainScreenList() = api.loadListForMainScreen()
}
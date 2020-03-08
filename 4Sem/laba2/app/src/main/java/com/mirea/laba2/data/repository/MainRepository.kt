package com.mirea.laba2.data.repository

import com.mirea.laba2.data.network.Api
import javax.inject.Inject

class MainRepository @Inject constructor(
    private val api: Api
)
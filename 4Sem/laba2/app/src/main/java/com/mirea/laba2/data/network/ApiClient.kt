package com.mirea.laba2.data.network

import com.mirea.laba2.data.network.response.MainScreenListResponse
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.http.GET

class ApiClient(retrofit: Retrofit): Api {

    interface Service {
        @GET("data/techs.ruleset.json")
        fun getMainScreenListAsync(): Deferred<List<MainScreenListResponse>>
    }

    private val service = retrofit.create(Service::class.java)

    override suspend fun loadListForMainScreen(): List<MainScreenListResponse> {
        return withContext(IO) { service.getMainScreenListAsync() }.await()
    }

}
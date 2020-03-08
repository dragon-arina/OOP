package com.mirea.laba2.data.network

import retrofit2.Retrofit

class ApiClient(retrofit: Retrofit): Api {

    interface Service {

    }

    private val service = retrofit.create(Service::class.java)

}
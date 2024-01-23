package com.example.thooughtctl_app.network

import com.example.thooughtctl_app.utils.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    val apiService: ImgurApiService by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(Constants.BASEURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        retrofit.create(ImgurApiService::class.java)
    }
}
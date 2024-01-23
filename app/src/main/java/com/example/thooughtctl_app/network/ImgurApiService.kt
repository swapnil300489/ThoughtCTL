package com.example.thooughtctl_app.network

import com.example.thooughtctl_app.RequestResponse.ImgurResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface ImgurApiService {
    @GET("3/gallery/hot/viral/0.json")
    fun getHotViralImages(@Header("Authorization") authorization: String): Call<ImgurResponse>

    @GET("3/gallery/search/top/0.json")
    fun searchGallery(@Header("Authorization") authorization: String,
                              @Query("q") query: String): Call<ImgurResponse>

}
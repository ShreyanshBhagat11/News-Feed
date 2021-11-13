package com.example.newsfeed

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    @GET("top-headlines")
    fun getNews(
        @Query("country") country: String?,
        @Query("pageSize") pagesize: Int,
        @Query("apiKey") apikey: String?
    ): Call<mainNews?>?

    @GET("top-headlines")
    fun getCategoryNews(
        @Query("country") country: String?,
        @Query("category") category: String?,
        @Query("pageSize") pagesize: Int,
        @Query("apiKey") apikey: String?
    ): Call<mainNews?>?

    companion object {
        const val BASE_URL = "https://newsapi.org/v2/"
    }
}
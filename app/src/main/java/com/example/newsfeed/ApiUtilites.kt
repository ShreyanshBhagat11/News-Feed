package com.example.newsfeed

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiUtilites {
    private var retrofit: Retrofit? = null
    @JvmStatic
    val apiInterface: ApiInterface
        get() {
            if (retrofit == null) {
                retrofit = Retrofit.Builder().baseUrl(ApiInterface.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit!!.create(ApiInterface::class.java)
        }
}
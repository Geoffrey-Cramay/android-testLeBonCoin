package com.example.gcramay.testleboncoin.data.remote

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Provider of photo remote service
 *
 * Created on 07/03/2018
 *
 * @version 1.0
 * @author gcramay
 */
object PhotoRemoteServiceProvider {
    const val BASE_URL = "http://jsonplaceholder.typicode.com/"
    fun getPhotoService(): PhotoRemoteService {
        val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        return retrofit.create(PhotoRemoteService::class.java)
    }
}
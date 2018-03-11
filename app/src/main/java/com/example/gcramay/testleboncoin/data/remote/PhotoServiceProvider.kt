package com.example.gcramay.testleboncoin.data.remote

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * //TODO : Add a class header comments
 *
 * Created on 07/03/2018
 *
 * @version 1.0
 * @author gcramay
 */
object PhotoServiceProvider {
    const val BASE_URL = "http://jsonplaceholder.typicode.com/"
    fun getPhotoService(): PhotoService {
        val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        return retrofit.create(PhotoService::class.java)
    }
}
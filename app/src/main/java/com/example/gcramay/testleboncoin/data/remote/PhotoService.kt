package com.example.gcramay.testleboncoin.data.remote

import com.example.gcramay.testleboncoin.data.remote.model.PhotoDataResponse
import io.reactivex.Single
import retrofit2.http.GET

/**
 * //TODO : Add a class header comments
 *
 * Created on 05/03/2018
 *
 * @version 1.0
 * @author gcramay
 */
interface PhotoService {
    @GET("photos")
    fun getPhotos(): Single<List<PhotoDataResponse>>
}
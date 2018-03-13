package com.example.gcramay.testleboncoin.data.remote

import com.example.gcramay.testleboncoin.data.remote.model.PhotoDataResponse
import io.reactivex.Single

/**
 * Implementation of PhotoRemoteService
 *
 * Created on 07/03/2018
 *
 * @version 1.0
 * @author gcramay
 */

class PhotoRemoteServiceImpl(private val photoRemoteService: PhotoRemoteService = PhotoRemoteServiceProvider.getPhotoService()) : PhotoRemoteService {
    override fun getPhotos(): Single<List<PhotoDataResponse>> {
        return photoRemoteService.getPhotos()
    }
}
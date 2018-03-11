package com.example.gcramay.testleboncoin.data.remote

import com.example.gcramay.testleboncoin.data.remote.model.PhotoDataResponse
import io.reactivex.Single

/**
 * //TODO : Add a class header comments
 *
 * Created on 07/03/2018
 *
 * @version 1.0
 * @author gcramay
 */

class PhotoServiceImpl(private val photoService: PhotoService = PhotoServiceProvider.getPhotoService()) : PhotoService {
    override fun getPhotos(): Single<List<PhotoDataResponse>> {
        return photoService.getPhotos()
    }
}
package com.example.gcramay.testleboncoin.domain.usecase

import com.example.gcramay.testleboncoin.data.repository.PhotoRepository
import com.example.gcramay.testleboncoin.domain.model.Photo
import io.reactivex.Single

/**
 * Use case for Photo
 *
 * Created on 05/03/2018
 *
 * @version 1.0
 * @author gcramay
 */

class PhotoUseCase(private val photoRepository: PhotoRepository) {

    fun getPhotos(): Single<List<Photo>> {
        return photoRepository.getPhotos()
    }
}
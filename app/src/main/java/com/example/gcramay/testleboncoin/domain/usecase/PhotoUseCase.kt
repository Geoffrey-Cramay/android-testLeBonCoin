package com.example.gcramay.testleboncoin.domain.usecase

import com.example.gcramay.testleboncoin.data.repository.PhotoRepository
import com.example.gcramay.testleboncoin.presentation.model.PhotoUiItem
import io.reactivex.Single

/**
 * //TODO : Add a class header comments
 *
 * Created on 05/03/2018
 *
 * @version 1.0
 * @author gcramay
 */

class PhotoUseCase(private val photoRepository: PhotoRepository) {

    fun getPhotos(): Single<List<PhotoUiItem>> {
        return photoRepository.getPhotos()
                .map {
                    it.map {
                        PhotoUiItem(it.albumId, it.id, it.title, it.url, it.thumbnailUrl)
                    }
                }
    }
}
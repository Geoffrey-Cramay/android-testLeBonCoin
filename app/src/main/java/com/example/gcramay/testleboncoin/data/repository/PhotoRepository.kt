package com.example.gcramay.testleboncoin.data.repository

import com.example.gcramay.testleboncoin.data.local.PhotoLocalService
import com.example.gcramay.testleboncoin.data.local.model.PhotoDataLocal
import com.example.gcramay.testleboncoin.data.remote.PhotoService
import com.example.gcramay.testleboncoin.domain.model.Photo
import io.reactivex.Single

/**
 * //TODO : Add a class header comments
 *
 * Created on 05/03/2018
 *
 * @version 1.0
 * @author gcramay
 */

class PhotoRepository(private val photoLocalService: PhotoLocalService, private val photoService: PhotoService) {

    fun getPhotos(): Single<List<Photo>> {
        val photoListFromDatabase by lazy {
            photoLocalService.getPhotos().map {
                it.map {
                    Photo(it.albumId, it.id, it.title, it.url, it
                            .thumbnail_url)
                }
            }
        }
        return photoService.getPhotos()
                .map {
                    savePhotos(it.map { PhotoDataLocal(it.albumId, it.id, it.title, it.url, it.thumbnailUrl) })
                    it.map { Photo(it.albumId, it.id, it.title, it.url, it.thumbnailUrl) }
                }.onErrorResumeNext({
            photoListFromDatabase
        })
    }

    fun savePhotos(photoList: List<PhotoDataLocal>) {
        photoLocalService.savePhotos(photoList)
    }
}
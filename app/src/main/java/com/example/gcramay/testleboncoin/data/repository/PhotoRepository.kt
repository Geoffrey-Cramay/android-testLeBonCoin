package com.example.gcramay.testleboncoin.data.repository

import com.example.gcramay.testleboncoin.data.local.PhotoLocalService
import com.example.gcramay.testleboncoin.data.local.model.PhotoDataLocal
import com.example.gcramay.testleboncoin.data.remote.PhotoRemoteService
import com.example.gcramay.testleboncoin.domain.model.Photo
import io.reactivex.Single

/**
 * Repository of Photo model
 *
 * Created on 05/03/2018
 *
 * @version 1.0
 * @author gcramay
 */

class PhotoRepository(private val photoLocalService: PhotoLocalService, private val photoRemoteService: PhotoRemoteService) {

    fun getPhotos(): Single<List<Photo>> {
        val photoListFromDatabase by lazy {
            photoLocalService.getPhotos().map {
                it.map {
                    Photo(it.albumId, it.id, it.title, it.url, it
                            .thumbnail_url)
                }
            }
        }

        return photoRemoteService.getPhotos()
                .map {
                    savePhotos(it.map { PhotoDataLocal(it.albumId, it.id, it.title, it.url, it.thumbnailUrl) })
                    it.map { Photo(it.albumId, it.id, it.title, it.url, it.thumbnailUrl) }
                }.onErrorResumeNext(
                //If there is no network connection we try to get data from dabatase
                { throwable ->
            photoListFromDatabase.map { list ->
                //If there is no data in database, we throw an exception
                if (list.isEmpty()) throw throwable
                list
            }
        })
    }

    fun savePhotos(photoList: List<PhotoDataLocal>) {
        photoLocalService.savePhotos(photoList)
    }
}
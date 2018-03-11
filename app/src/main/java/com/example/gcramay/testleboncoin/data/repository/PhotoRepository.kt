package com.example.gcramay.testleboncoin.data.repository

import android.util.Log
import com.example.gcramay.testleboncoin.data.local.PhotoLocalServiceImpl
import com.example.gcramay.testleboncoin.data.local.model.PhotoDataLocal
import com.example.gcramay.testleboncoin.data.remote.PhotoServiceImpl
import com.example.gcramay.testleboncoin.domain.model.Photo
import io.reactivex.Completable
import io.reactivex.Single

/**
 * //TODO : Add a class header comments
 *
 * Created on 05/03/2018
 *
 * @version 1.0
 * @author gcramay
 */

class PhotoRepository(private val photoLocalServiceImpl: PhotoLocalServiceImpl, private val photoServiceImpl: PhotoServiceImpl) {

    fun getPhotos(): Single<List<Photo>> {
        val photoListFromDatabase = photoLocalServiceImpl.getPhotos().map {
            it.map {
                Photo(it.albumId, it.id, it.title, it.url, it
                        .thumbnail_url)
            }
        }
        return photoServiceImpl.getPhotos()
                .map {
                    savePhotos(it.map { PhotoDataLocal(it.albumId, it.id, it.title, it.url, it.thumbnailUrl) })
                    it.map { Photo(it.albumId, it.id, it.title, it.url, it.thumbnailUrl) }
                }.onErrorResumeNext({
            photoListFromDatabase
        })
    }

    fun savePhotos(photoList: List<PhotoDataLocal>){
        photoLocalServiceImpl.savePhotos(photoList)
    }
}
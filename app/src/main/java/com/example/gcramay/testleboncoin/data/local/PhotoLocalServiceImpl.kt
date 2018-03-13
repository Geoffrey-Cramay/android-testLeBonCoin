package com.example.gcramay.testleboncoin.data.local

import android.content.Context
import com.example.gcramay.testleboncoin.data.local.model.PhotoDataLocal
import io.reactivex.Single

/**
 * Implementation of PhotoLocalService
 *
 * Created on 08/03/2018
 *
 * @version 1.0
 * @author gcramay
 */
class PhotoLocalServiceImpl(private val database: PhotoDatabase) : PhotoLocalService {
    override fun getPhotos(): Single<List<PhotoDataLocal>> {
        return database.photoDao().getPhotos()
    }

    override fun savePhotos(photoList: List<PhotoDataLocal>) {
        return database.photoDao().save(photoList)
    }
}
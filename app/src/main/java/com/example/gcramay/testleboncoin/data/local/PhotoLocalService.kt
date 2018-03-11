package com.example.gcramay.testleboncoin.data.local

import com.example.gcramay.testleboncoin.data.local.model.PhotoDataLocal
import io.reactivex.Single

/**
 * //TODO : Add a class header comments
 *
 * Created on 08/03/2018
 *
 * @version 1.0
 * @author gcramay
 */
interface PhotoLocalService {
    fun getPhotos(): Single<List<PhotoDataLocal>>

    fun savePhotos(photoList: List<PhotoDataLocal>)
}
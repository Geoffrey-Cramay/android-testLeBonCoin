package com.example.gcramay.testleboncoin.data.local.model

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import io.reactivex.Single

/**
 * DAO for PhotoDataLocal
 *
 * Created on 06/03/2018
 *
 * @version 1.0
 * @author gcramay
 */

@Dao
interface PhotoDao {
    @Query("SELECT * FROM photo")
    fun getPhotos(): Single<List<PhotoDataLocal>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun save(photoDataLocalList: List<PhotoDataLocal>)
}
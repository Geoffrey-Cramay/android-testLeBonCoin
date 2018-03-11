package com.example.gcramay.testleboncoin.data.local

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.example.gcramay.testleboncoin.data.local.model.PhotoDataLocal
import com.example.gcramay.testleboncoin.data.local.model.PhotoDao

/**
 * //TODO : Add a class header comments
 *
 * Created on 06/03/2018
 *
 * @version 1.0
 * @author gcramay
 */
@Database(entities = arrayOf(PhotoDataLocal::class), version = 1)
abstract class PhotoDatabase : RoomDatabase() {
    abstract fun photoDao() : PhotoDao
}

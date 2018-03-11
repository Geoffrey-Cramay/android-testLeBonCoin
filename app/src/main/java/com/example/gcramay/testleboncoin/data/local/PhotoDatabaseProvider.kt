package com.example.gcramay.testleboncoin.data.local

import android.arch.persistence.room.Room
import android.content.Context

/**
 * //TODO : Add a class header comments
 *
 * Created on 07/03/2018
 *
 * @version 1.0
 * @author gcramay
 */
class PhotoDatabaseProvider(val context: Context) {
    companion object {
        const val DATABASE_NAME = "photo-database"
    }

    val database by lazy { Room.databaseBuilder(context, PhotoDatabase::class.java, DATABASE_NAME).build() }
}
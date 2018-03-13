package com.example.gcramay.testleboncoin.data.local

import android.arch.persistence.room.Room
import android.content.Context

/**
 * Provider of photo database
 *
 * Created on 07/03/2018
 *
 * @version 1.0
 * @author gcramay
 */
class PhotoDatabaseProvider(private val context: Context) {
    companion object {
        const val DATABASE_NAME = "photo-database"
    }

    val database by lazy { Room.databaseBuilder(context, PhotoDatabase::class.java, DATABASE_NAME).build() }
}
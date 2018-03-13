package com.example.gcramay.testleboncoin.data.local.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Class used to represent a photo in database
 *
 * Created on 06/03/2018
 *
 * @version 1.0
 * @author gcramay
 */

@Entity(tableName = "photo")
data class PhotoDataLocal(val albumId : Int,
                          @PrimaryKey(autoGenerate = false) val id: Int,
                          val title: String,
                          val url: String,
                          val thumbnail_url: String)
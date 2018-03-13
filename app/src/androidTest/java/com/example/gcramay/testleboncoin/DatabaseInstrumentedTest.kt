package com.example.gcramay.testleboncoin

import android.arch.persistence.room.Room
import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
import com.example.gcramay.testleboncoin.data.local.PhotoDatabase
import com.example.gcramay.testleboncoin.data.local.model.PhotoDataLocal
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Class used to test Photo Database interactions
 *
 * Created on 12/03/2018
 *
 * @author gcramay
 * @version 1.0
 */
@RunWith(AndroidJUnit4::class)
class DatabaseInstrumentedTest {

    private val context by lazy { InstrumentationRegistry.getTargetContext()!! }
    private lateinit var database: PhotoDatabase

    @Before
    fun setup() {
        database = Room.inMemoryDatabaseBuilder(context, PhotoDatabase::class.java)
                // allowing main thread queries, just for testing
                .allowMainThreadQueries()
                .build()
    }

    @After
    fun tearsDown() {
        database.close()
    }

    @Test
    fun addPhotoInDatabase() {
        val photo = PhotoDataLocal(1, 1, "title", "url", "thumbnail_url")
        val photo2 = PhotoDataLocal(1, 2, "title2", "url2", "thumbnail_url2")
        val photoList = listOf(photo, photo2)
        database.photoDao().save(photoList)

        database.photoDao().getPhotos()
                .test()
                .assertValue(
                        {
                            it.size == 2 && arePhotosTheSame(photo, it[0])
                                    && arePhotosTheSame(photo2, it[1])
                        })
    }

    @Test
    fun updatePhotoInDatabase() {
        val photo = PhotoDataLocal(1, 1, "title", "url", "thumbnail_url")
        val photoList = mutableListOf(photo)
        database.photoDao().save(photoList)
        val photo2 = PhotoDataLocal(2, 1, "title2", "url2", "thumbnail_url2")
        photoList.add(photo2)
        database.photoDao().save(photoList)
        database.photoDao().getPhotos()
                .test()
                .assertValue(
                        {
                            it.size == 1 && arePhotosTheSame(photo2, it[0])
                        })
    }

    private fun arePhotosTheSame(originalPhoto: PhotoDataLocal, photoSaved: PhotoDataLocal): Boolean =
            originalPhoto.albumId == photoSaved.albumId &&
                    originalPhoto.id == photoSaved.id &&
                    originalPhoto.title == photoSaved.title &&
                    originalPhoto.url == photoSaved.url &&
                    originalPhoto.thumbnail_url == photoSaved.thumbnail_url

}

package com.example.gcramay.testleboncoin

import com.example.gcramay.testleboncoin.data.local.PhotoLocalService
import com.example.gcramay.testleboncoin.data.local.model.PhotoDataLocal
import com.example.gcramay.testleboncoin.data.remote.PhotoRemoteService
import com.example.gcramay.testleboncoin.data.remote.model.PhotoDataResponse
import com.example.gcramay.testleboncoin.data.repository.PhotoRepository
import com.example.gcramay.testleboncoin.domain.model.Photo
import io.reactivex.Single
import org.junit.Assert
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.*

/**
 * Class used to test PhotoRepository logic
 *
 * Created on 12/03/2018
 *
 * @author gcramay
 * @version 1.0
 */
class RepositoryUnitTest {

    private val photoRemoteService = Mockito.mock(PhotoRemoteService::class.java)
    private val photoLocalService = Mockito.mock(PhotoLocalService::class.java)
    private var photoRepository = PhotoRepository(photoLocalService, photoRemoteService)

    private val remoteList = listOf(PhotoDataResponse(1, 1, "title1", "url", "thumb"),
            PhotoDataResponse(1, 2, "title1", "url", "thumb"))
    private val remoteRepositoryList = listOf(Photo(1, 1, "title1", "url", "thumb"),
            Photo(1, 2, "title1", "url", "thumb"))
    private val localList = listOf(PhotoDataLocal(1, 1, "title1", "url", "thumb"), PhotoDataLocal(1, 2, "title1", "url",
            "thumb"))
    private val localRepositorylList = listOf(Photo(1, 1, "title1", "url", "thumb"), Photo(1, 2, "title1", "url", "thumb"))

    @Test
    fun testGetFromRemoteService() {
        `when`(photoRemoteService.getPhotos()).thenReturn(Single.just(remoteList))

        val result = mutableListOf<Photo>()
        photoRepository.getPhotos().subscribe({ list ->
            result.addAll(list)
        })

        Assert.assertEquals(result, remoteRepositoryList)

        verify(photoLocalService).savePhotos(localList)
        verify(photoLocalService, never()).getPhotos()
    }

    @Test
    fun testGetFromLocalService() {
        `when`(photoRemoteService.getPhotos()).thenReturn(Single.error(Throwable()))
        `when`(photoLocalService.getPhotos()).thenReturn(Single.just(localList))

        val result = mutableListOf<Photo>()
        photoRepository.getPhotos().subscribe(
                { list -> result.addAll(list) })

        Assert.assertEquals(result, localRepositorylList)

        verify(photoLocalService, never()).savePhotos(localList)
        verify(photoLocalService).getPhotos()
    }

    @Test
    fun testGetFromLocalServiceWithoutData() {
        `when`(photoRemoteService.getPhotos()).thenReturn(Single.error(Throwable()))
        `when`(photoLocalService.getPhotos()).thenReturn(Single.error(Throwable()))

        var result: Throwable? = null
        photoRepository.getPhotos().subscribe({}, { result = it })

        Assert.assertNotNull(result)
    }
}

package com.example.gcramay.testleboncoin

import com.example.gcramay.testleboncoin.domain.model.Photo
import com.example.gcramay.testleboncoin.presentation.model.PhotoUiItem
import com.example.gcramay.testleboncoin.presentation.viewmodel.PhotoViewModel
import io.reactivex.Single
import org.junit.Assert
import org.junit.Test
import org.mockito.Mockito.mock

/**
 * Class used to test PhotoViewModel conversion
 *
 * Created on 12/03/2018
 *
 * @author gcramay
 * @version 1.0
 */
class ViewModelUnitTest {

    private var photoViewModel = mock(PhotoViewModel::class.java)

    private val useCaseList = listOf(Photo(1, 1, "title1", "url", "thumb"),
            Photo(1, 2, "title1", "url", "thumb"))
    private val viewModelList = listOf(PhotoUiItem(1, 1, "title1", "url", "thumb"),
            PhotoUiItem(1, 2, "title1", "url", "thumb"))

    @Test
    fun testViewModel() {
        val result = mutableListOf<PhotoUiItem>()
        photoViewModel.convert(Single.just(useCaseList)).subscribe({ list ->
            result.addAll(list)
        })
        Assert.assertEquals(viewModelList, result)
    }
}
package com.example.gcramay.testleboncoin.presentation.viewmodel

import android.arch.lifecycle.ViewModel
import com.example.gcramay.testleboncoin.domain.model.Photo
import com.example.gcramay.testleboncoin.domain.usecase.PhotoUseCase
import com.example.gcramay.testleboncoin.presentation.model.PhotoUiItem
import io.reactivex.Single

/**
 * ViewModel that generates an observable used to get Photo data for the UI
 *
 * Created on 06/03/2018
 *
 * @version 1.0
 * @author gcramay
 */

open class PhotoViewModel(private val photoUseCase: PhotoUseCase) : ViewModel() {
    private val observable by lazy {
        convert(photoUseCase.getPhotos())
                .cache()
    }

    internal fun convert(single: Single<List<Photo>>) = single.map {
        it.map {
            PhotoUiItem(it.albumId, it.id, it.title, it.url, it
                    .thumbnailUrl)
        }
    }

    fun getPhotos(): Single<List<PhotoUiItem>> {
        return observable
    }
}
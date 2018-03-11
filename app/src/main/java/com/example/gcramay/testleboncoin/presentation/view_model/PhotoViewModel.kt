package com.example.gcramay.testleboncoin.presentation.view_model

import android.arch.lifecycle.ViewModel
import android.content.Context
import android.util.Log
import com.example.gcramay.testleboncoin.data.RepositoryProvider
import com.example.gcramay.testleboncoin.domain.usecase.PhotoUseCase
import com.example.gcramay.testleboncoin.presentation.model.PhotoUiItem
import io.reactivex.Single

/**
 * //TODO : Add a class header comments
 *
 * Created on 06/03/2018
 *
 * @version 1.0
 * @author gcramay
 */

class PhotoViewModel(context: Context) : ViewModel() {
    private val photoUseCase = PhotoUseCase(RepositoryProvider(context).photoRepository)
    private val observable by lazy {
        photoUseCase.getPhotos().cache()
    }

    fun getPhotos(): Single<List<PhotoUiItem>> {
        return observable
    }
}
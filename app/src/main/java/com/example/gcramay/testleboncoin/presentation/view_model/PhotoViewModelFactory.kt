package com.example.gcramay.testleboncoin.presentation.view_model

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.content.Context
import com.example.gcramay.testleboncoin.data.repository.RepositoryProvider
import com.example.gcramay.testleboncoin.domain.usecase.PhotoUseCase

/**
 * //TODO : Add a class header comments
 *
 * Created on 07/03/2018
 *
 * @version 1.0
 * @author gcramay
 */

class PhotoViewModelFactory(private val context: Context) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PhotoViewModel::class.java)) {
            return PhotoViewModel(PhotoUseCase(RepositoryProvider(context).photoRepository)) as T
        }
        throw IllegalArgumentException("Unknow ViewModel Class");
    }
}
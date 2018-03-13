package com.example.gcramay.testleboncoin.presentation.viewmodel

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.content.Context
import com.example.gcramay.testleboncoin.data.repository.RepositoryProvider
import com.example.gcramay.testleboncoin.domain.usecase.PhotoUseCase

/**
 * Factory used to create PhotoViewModel
 *
 * Created on 07/03/2018
 *
 * @version 1.0
 * @author gcramay
 */

class PhotoViewModelFactory(private val context: Context) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PhotoViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return PhotoViewModel(PhotoUseCase(RepositoryProvider(context).photoRepository)) as T
        }
        throw IllegalArgumentException("Unknow ViewModel Class");
    }
}
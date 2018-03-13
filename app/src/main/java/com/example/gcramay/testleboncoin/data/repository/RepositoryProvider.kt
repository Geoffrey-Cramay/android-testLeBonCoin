package com.example.gcramay.testleboncoin.data.repository

import android.content.Context
import com.example.gcramay.testleboncoin.data.local.PhotoDatabaseProvider
import com.example.gcramay.testleboncoin.data.local.PhotoLocalServiceImpl
import com.example.gcramay.testleboncoin.data.remote.PhotoRemoteServiceImpl

/**
 * Provider of PhotoRepository
 *
 * Created on 09/03/2018
 *
 * @version 1.0
 * @author gcramay
 */

class RepositoryProvider(val context: Context) {
    val photoRepository by lazy  {PhotoRepository(PhotoLocalServiceImpl(PhotoDatabaseProvider(context).database), PhotoRemoteServiceImpl())}
}
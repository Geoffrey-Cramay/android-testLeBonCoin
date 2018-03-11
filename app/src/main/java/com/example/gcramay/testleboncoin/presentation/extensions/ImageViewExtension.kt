package com.example.gcramay.testleboncoin.presentation.extensions

import android.support.v7.widget.AppCompatImageView
import android.text.TextUtils
import com.bumptech.glide.Glide

/**
 * //TODO : Add a class header comments
 *
 * Created on 10/03/2018
 *
 * @version 1.0
 * @author gcramay
 */

fun AppCompatImageView.loadImage(imageUrl: String) {
    if (!TextUtils.isEmpty(imageUrl)) {
        Glide.with(context).load(imageUrl).into(this)
    }
}

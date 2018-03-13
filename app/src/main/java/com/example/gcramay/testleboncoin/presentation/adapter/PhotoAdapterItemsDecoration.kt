package com.example.gcramay.testleboncoin.presentation.adapter

import android.graphics.Rect
import android.support.annotation.IntegerRes
import android.support.v7.widget.RecyclerView
import android.view.View

/**
 * Decoration for each items of PhotoAdapter
 *
 * Created on 10/03/2018
 *
 * @version 1.0
 * @author gcramay
 */

class PhotoAdapterItemsDecoration(private val preferredMargin: Int) : RecyclerView.ItemDecoration() {
    override fun getItemOffsets(outRect: Rect?, view: View?, parent: RecyclerView?, state: RecyclerView.State?) {
        super.getItemOffsets(outRect, view, parent, state)
        outRect!!.top = preferredMargin / 2
        outRect.bottom = preferredMargin / 2
        outRect.left = preferredMargin / 2
        outRect.right = preferredMargin / 2
    }
}
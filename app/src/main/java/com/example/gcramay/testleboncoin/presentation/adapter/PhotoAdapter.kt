package com.example.gcramay.testleboncoin.presentation.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.gcramay.testleboncoin.R
import com.example.gcramay.testleboncoin.presentation.extensions.loadImage
import com.example.gcramay.testleboncoin.presentation.model.PhotoUiItem
import kotlinx.android.synthetic.main.photo_list_item.view.*

/**
 * Adapter responsible for photo display in UI
 *
 * Created on 10/03/2018
 *
 * @version 1.0
 * @author gcramay
 */
class PhotoAdapter(val listItems: List<PhotoUiItem>) : RecyclerView.Adapter<PhotoAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(LayoutInflater.from(parent
            .context).inflate(R.layout.photo_list_item, parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(listItems.get(position))

    override fun getItemCount(): Int = listItems.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(photoUiItem: PhotoUiItem) {
            itemView.item_title.text = photoUiItem.title
            itemView.item_photo.loadImage(photoUiItem.thumbnailUrl)
        }
    }
}


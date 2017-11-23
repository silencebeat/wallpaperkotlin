package com.silencebeat.wallpapersearch.Views

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import kotlinx.android.synthetic.main.item_image.view.*

/**
 * Created by Candra Triyadi on 23/11/2017.
 */
class ImageViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    fun onBind(context: Context, imgUrl: String) = with(itemView){

        Glide.with(context)
                .load(imgUrl).asBitmap()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .fitCenter()
                .dontAnimate()
                .into(image)
    }
}
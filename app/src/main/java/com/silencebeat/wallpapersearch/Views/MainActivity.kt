package com.silencebeat.wallpapersearch.Views

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import com.silencebeat.wallpapersearch.Modules.WallpaperInteractor
import com.silencebeat.wallpapersearch.Modules.WallpaperPresenter
import com.silencebeat.wallpapersearch.Modules.WallpaperView
import com.silencebeat.wallpapersearch.R
import com.silencebeat.wallpapersearch.Utils.Adapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), WallpaperView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setToolbar()

        val presenter = WallpaperPresenter(WallpaperInteractor(),this, this)
        presenter.getWallpaper()
    }

    fun setToolbar(){
        setSupportActionBar(toolbar)
    }

    override fun getWallpaperSuccess(list: ArrayList<String>) {
        setData(list)
    }

    fun setData(list: ArrayList<String>){
        val manager = GridLayoutManager(this, 2)
        val adapter = object: Adapter<String, ImageViewHolder>(R.layout.item_image, ImageViewHolder::class.java, String::class.java, list){

            override fun bindView(holder: ImageViewHolder, tipeData: String, position: Int) {
                holder.onBind(applicationContext, tipeData)
            }
        }

        list_image.layoutManager = manager
        list_image.adapter = adapter
    }


}

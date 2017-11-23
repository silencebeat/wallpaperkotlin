package com.silencebeat.wallpapersearch.Modules

import android.app.Activity
import com.silencebeat.wallpapersearch.R

/**
 * Created by Candra Triyadi on 23/11/2017.
 */
class WallpaperPresenter(var interactor: WallpaperInteractor,
                         var view: WallpaperView,
                         var activity: Activity): WallpaperInterface, WallpaperOutput{


    var userAgent = ""
    var keyword = ""
    var resource = ""

    init {
        interactor.output = this
        userAgent = activity.resources.getString(R.string.user_agent)
        keyword = activity.resources.getString(R.string.query)
        resource = activity.resources.getString(R.string.source)
    }

    override fun getWallpaper() {
        interactor.getData(keyword, userAgent, resource)
    }

    override fun getWallpaperSuccess(list: ArrayList<String>) {
        view.getWallpaperSuccess(list)
    }


}
package com.silencebeat.wallpapersearch.Modules

/**
 * Created by Candra Triyadi on 23/11/2017.
 */

interface WallpaperView{
    fun getWallpaperSuccess(list: ArrayList<String>)
}

interface WallpaperInterface{
    fun getWallpaper()
}

interface WallpaperOutput{
    fun getWallpaperSuccess(list: ArrayList<String>)
}

interface WallpaperInput{
    fun getData(keyword: String, userAgent: String, resource: String)
}
package com.silencebeat.wallpapersearch.Modules

import android.os.AsyncTask
import org.json.simple.JSONObject
import org.json.simple.parser.JSONParser
import org.jsoup.Jsoup
import org.jsoup.nodes.Document

/**
 * Created by Candra Triyadi on 23/11/2017.
 */
class WallpaperInteractor : AsyncTask<String, Int, Document>(), WallpaperInput {


    lateinit var output: WallpaperOutput
    var resultList = ArrayList<String>()
    var keyword = ""
    var userAgent = ""
    var resource = ""

    override fun getData(keyword: String, userAgent: String, resource: String) {
        this.keyword = keyword
        this.userAgent = userAgent
        this.resource = resource
        execute()
    }

    override fun doInBackground(vararg p0: String?): Document {
        var doc: Document
        doc = Jsoup.connect("https://www.google.com/search?site=imghp&tbm=isch&source=hp&q="+ keyword +"+site:"+resource+"&gws_rd=cr&tbm=isch&tbs=isz:m")
                .userAgent(userAgent).referrer("https://www.google.com/")
                .get()

        return doc
    }

    override fun onPostExecute(result: Document?) {
        var elements = result!!.select("div.rg_meta")
        var jsonObject: JSONObject

        for (item in elements){
            if (item.childNodeSize() > 0){
                jsonObject = JSONParser().parse(item.childNode(0).toString()) as JSONObject
                var url = jsonObject.get("ou") as String
                resultList.add(url)
            }
        }

        output.getWallpaperSuccess(resultList)

    }
}
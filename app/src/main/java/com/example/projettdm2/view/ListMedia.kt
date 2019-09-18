package com.example.projettdm2.view

import android.content.Context
import android.view.ViewGroup
import android.widget.HorizontalScrollView
import android.widget.ImageView
import android.widget.LinearLayout
import com.example.projettdm2.internet.GetImages
import com.example.projettdm2.internet.IGetImages

class ListMedia(var ctx: Context, var media: ArrayList<String>):HorizontalScrollView(ctx) {
    var ll = LinearLayout(ctx)
    var cnx: IGetImages = GetImages()
    init {
        var param = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        this.layoutParams = param
        this.addView(ll)
        ll.layoutParams = param

        for(i in media){
            try {
                cnx.getImages(i,this)
            }catch (e:Exception){
                println(e)
            }
        }
    }

    fun add_img(img:ImageView){
        ll.addView(img)
    }
}
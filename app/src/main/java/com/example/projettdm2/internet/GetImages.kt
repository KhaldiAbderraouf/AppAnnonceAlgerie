package com.example.projettdm2.internet

import com.example.projettdm2.view.ListMedia
import android.widget.ImageView
import com.squareup.picasso.Picasso
import org.jetbrains.anko.doAsync


class GetImages:IGetImages {
    override fun getImages(url: String, media: ListMedia) {
        val imageView = ImageView(media.ctx)
            Picasso.get()
                .load(url)
                .resize(300, 200)
                .into(imageView)
            media.add_img(imageView)
    }

}
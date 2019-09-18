package com.example.projettdm2.view

import android.content.Context
import android.content.Intent
import android.os.Build
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import com.example.projettdm2.AnnonceViewActivity
import com.example.projettdm2.model.Annonce
import com.squareup.picasso.Picasso

class AnnonceView (var ctx: Context, var a: Annonce): LinearLayout(ctx) {
    var param = LinearLayout.LayoutParams(
        LinearLayout.LayoutParams.MATCH_PARENT,
        ViewGroup.LayoutParams.WRAP_CONTENT
    )
    init {
        this.layoutParams = param
        this.orientation = HORIZONTAL
        this.addView(leftSide(a))
        this.addView(rightSide(a))
    }


    fun rightSide(a: Annonce):LinearLayout{
        val l = LinearLayout(ctx)
        l.layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        l.orientation = VERTICAL

        l.addView(addTwo("categorie",a.categorie))
        l.addView(addTwo("type",a.type))
        l.addView(addTwo("wilaya",a.wilaya))
        l.addView(addTwo("surface",a.surface.toString()))
        l.addView(addTwo("prix",a.prix.toString()))

        return l
    }

    fun leftSide(a: Annonce):LinearLayout{
        val l = LinearLayout(ctx)
        l.layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        l.orientation = VERTICAL

        val img = ImageView(ctx)
        Picasso.get()
            .load(a.media.get(0))
            .resize(200, 150)
            .into(img)

        l.addView(img)
        l.addView(addTwo("id",a.id))
        return l
    }

    private fun addTwo(string1: String, string2: String):LinearLayout{
        val l = LinearLayout(ctx)
        l.orientation = HORIZONTAL
        l.layoutParams=param
        l.addView(txt(string1))
        l.addView(txt(string2))
        return l
    }

    private fun txt(string1: String): TextView {
        val txt1 = TextView(ctx)
        txt1.layoutParams = param
        txt1.setText(string1)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            txt1.setTextAppearance(android.R.style.TextAppearance_Material_Large)
        }
        return txt1
    }
}
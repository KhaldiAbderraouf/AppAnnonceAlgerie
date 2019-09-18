package com.example.projettdm2.view

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.example.projettdm2.model.Annonce

class ListeAnnonceView(var ctx: Context):LinearLayout(ctx),Observer {
    override fun update(o: Any) {
        l = ListeView(ctx)
        l.load(o as ArrayList<Annonce>)
    }

    var l:ListeView = ListeView(ctx)
    init {
        val param = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        this.layoutParams = param
        this.orientation = LinearLayout.VERTICAL
        this.addView(l)
    }
    fun load(annonces: ArrayList<Annonce>){
        l = ListeView(ctx)
        l.load(annonces)
    }
}
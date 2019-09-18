package com.example.projettdm2.view

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.example.projettdm2.model.Annonce

class ListeView(var ctx: Context ): LinearLayout(ctx) {
    lateinit var l:ArrayList<AnnonceView>
    init {
        val param = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        this.layoutParams = param
        this.orientation = VERTICAL
    }
    fun load(annonces: ArrayList<Annonce>){
        for (a in annonces){
            this.addView(AnnonceView(ctx,a))
        }
    }
}

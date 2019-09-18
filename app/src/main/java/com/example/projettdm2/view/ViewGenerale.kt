package com.example.projettdm2.view

import android.content.Context
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.ScrollView
import com.example.projettdm2.controler.AnnoncesControler
import android.R
import android.graphics.Color
import android.view.View


class ViewGenerale(
        var ctx: Context,
        var c: AnnoncesControler,
        var la: ListeAnnonceView,
        var lsv: ListeSavedView,
        var lsg: ListeSignetView,
        var p: Profile
        ):ScrollView(ctx){
    var l = LinearLayout(ctx)
    var btnLA = Button(ctx)//,null,android.R.style.TextAppearance_Material_Widget_Button_Borderless_Colored)
    var btnLSv = Button(ctx)//,null,android.R.style.TextAppearance_Material_Widget_Button_Borderless_Colored)
    var btnLSg = Button(ctx)//,null,android.R.style.TextAppearance_Material_Widget_Button_Borderless_Colored)
    var btnP = Button(ctx)//,null,android.R.style.TextAppearance_Material_Widget_Button_Borderless_Colored)
    var bare = View(ctx)

    init {
        bare = bare()
        l.addView(bare)
        l.addView(la)
        this.addView(l)
    }

    private fun bare(): LinearLayout {
        val l = LinearLayout(ctx)
        l.setBackgroundColor(Color.parseColor("#00BCD4"))
        val param = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        param.weight = 1f
        btnLA.layoutParams = param
        btnLA.setText("Home")
        btnLA.setOnClickListener { switch(la) }
        var i = 90001
        la.setId(i)

        btnLSv.layoutParams = param
        btnLSv.setText("Saved")
        btnLSv.setOnClickListener { switch(lsv) }
        i = 90002
        lsv.setId(i)

        btnLSg.layoutParams = param
        btnLSg.setText("Signet")
        btnLSg.setOnClickListener { switch(lsg) }
        i = 90003
        lsg.setId(i)

        btnP.layoutParams = param
        btnP.setText("Profile")
        btnP.setOnClickListener { switch(p) }
        i = 90004
        p.setId(i)

        l.addView(btnLA)
        l.addView(btnLSv)
        l.addView(btnLSg)
        l.addView(btnP)
        return l
    }

    fun switch(v:View){

        l.removeAllViews()
        l.addView(bare)
        l.addView(v)
    }
}
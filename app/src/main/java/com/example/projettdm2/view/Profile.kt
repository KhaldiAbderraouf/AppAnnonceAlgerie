package com.example.projettdm2.view

import android.content.Context
import android.os.Build
import android.view.Gravity
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import com.example.projettdm2.model.User

class Profile(var ctx: Context, var user: User): LinearLayout(ctx) {
    var nom = EditText(ctx)
    var suivis = EditText(ctx)
    var suivre = Button(ctx)
    val dp = 2.6
    init {
        var param = LayoutParams(LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        val txt_nom = TextView(ctx)
        txt_nom.setText("Name")
        txt_nom.layoutParams = param
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            txt_nom.setTextAppearance(android.R.style.TextAppearance_Material_Large)
        }
        val txt_suivis = TextView(ctx)
        txt_suivis.setText("Suivis")
        txt_suivis.layoutParams = param
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            txt_suivis.setTextAppearance(android.R.style.TextAppearance_Material_Large)
        }
        nom.layoutParams = param
        nom.setEms(10)
        nom.hint = "Name"

        suivis.layoutParams = param
        suivis.setEms(10)
        suivis.hint = "Wilaya"

        suivre.layoutParams = param
        suivre.setText("SUIVRE")

        val profile = TextView(ctx)
        param.gravity = Gravity.CENTER
        profile.layoutParams = param

        this.orientation = VERTICAL
        param.setMargins((50*dp).toInt(),(50*dp).toInt(),(50*dp).toInt(),(50*dp).toInt())
        this.layoutParams = param

        this.addView(profile)
        this.addView(txt_nom)
        this.addView(nom)
        this.addView(txt_suivis)
        this.addView(suivis)
        this.addView(suivre)
    }
    fun load(wilaya: String){
        nom.setText(user.id)
        suivis.setText(wilaya)
    }
}
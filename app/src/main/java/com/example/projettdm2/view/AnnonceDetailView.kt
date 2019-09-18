package com.example.projettdm2.view

import android.content.Context
import android.os.Build
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import com.example.projettdm2.model.Annonce

class AnnonceDetailView(var ctx: Context, var a:Annonce): LinearLayout(ctx) {
    var param = LinearLayout.LayoutParams(
        LinearLayout.LayoutParams.MATCH_PARENT,
        ViewGroup.LayoutParams.WRAP_CONTENT
    )
    init {
        this.layoutParams = param
        this.orientation = VERTICAL
        val media = ListMedia(ctx,a.media)
        this.addView(addFour("categorie: ",a.categorie,"type: ",a.type))
        this.addView(addFour("wilaya: ",a.wilaya,"commune: ",a.Commune))
        this.addView(addTwo("adresse: ", a.adresse))
        this.addView(addFour("surface: ",a.surface.toString(),"prix: ",a.prix.toString()))

        val txt1 = TextView(ctx)
        txt1.layoutParams = param
        txt1.setText("description")
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            txt1.setTextAppearance(android.R.style.TextAppearance_Material_Large)
        }
        val txt2 = TextView(ctx)
        txt2.setLines(4)
        txt2.layoutParams = param
        txt2.setText(a.description)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            txt1.setTextAppearance(android.R.style.TextAppearance_Material_Large)
        }

        this.addView(addFour("nom", a.nom, "prenom", a.prenom))
        this.addView(addTwo("adresse",a.adresse_annonceur))
        this.addView(addTwo("email",a.email))
        this.addView(addTwo("tel",a.tel1))
        this.addView(addTwo("tel",a.tel2))

    }

    private fun addFour(string1: String, string2: String, string3: String, string4: String):LinearLayout{
        val l = LinearLayout(ctx)
        l.orientation = HORIZONTAL
        l.layoutParams=param
        l.addView(txt(string1))
        l.addView(txt(string2))
        l.addView(txt(string3))
        l.addView(txt(string4))
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

    private fun txt(string1: String):TextView{
        val txt1 = TextView(ctx)
        txt1.layoutParams = param
        txt1.setText(string1)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            txt1.setTextAppearance(android.R.style.TextAppearance_Material_Large)
        }
        return txt1
    }

}

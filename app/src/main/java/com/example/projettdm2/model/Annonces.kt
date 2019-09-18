package com.example.projettdm2.model

import com.example.projettdm2.internet.GetAnnonces
import com.example.projettdm2.internet.IGetAnnonces
import com.example.projettdm2.view.Observer
import java.util.*
import kotlin.collections.ArrayList

class Annonces() :Subject {
    override var observers = ArrayList<Observer>()
    private lateinit var annonces:ArrayList<Annonce>
    var cnx: IGetAnnonces = GetAnnonces()


    fun addAnnonces(date: Date, wilaya:String){
        cnx.getListeAnnonces(date,wilaya,this)
    }

    fun getAnnonces(): ArrayList<Annonce> {
        return annonces
    }

    fun getAnnonce(id:String): Annonce? {
        for(a in annonces){
            if (a.equals(id)) return a
        }
        return null
    }

    override fun update() {
        for(o in observers){
            o.update(annonces)
        }
    }

}
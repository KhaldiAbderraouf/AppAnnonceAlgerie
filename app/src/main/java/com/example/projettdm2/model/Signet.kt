package com.example.projettdm2.model

import com.example.projettdm2.internet.GetSignet
import com.example.projettdm2.internet.IGetSignet
import com.example.projettdm2.view.Observer

class Signet:Subject {
    private lateinit var signet:ArrayList<Annonce>
    var cnx: IGetSignet = GetSignet()

    override var observers = ArrayList<Observer>()

    override fun update() {
        for(o in observers){
            o.update(signet)
        }
    }


    fun add(a:Annonce,user: User){
        cnx.add(user,a)
        signet.add(a)
        this.update()
    }

    fun getList():ArrayList<Annonce>{
        return signet
    }

    fun get(id:String): Annonce? {
        for(a in signet){
            if (a.equals(id)) return a
        }
        return null
    }

    fun loadAnnonces(user: User){
        cnx.getListeSignets(user,this)
    }
}
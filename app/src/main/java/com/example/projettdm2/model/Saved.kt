package com.example.projettdm2.model

import com.example.projettdm2.database.DataBaseHandler
import com.example.projettdm2.view.Observer

class Saved(var dbh: DataBaseHandler):Subject {
    lateinit var saved:ArrayList<Annonce>
    init {
        load_db()
    }

    fun load_db() {
        dbh.load_db(this)
    }

    override var observers = ArrayList<Observer>()

    override fun update() {
        for(o in observers){
            o.update(saved)
        }
    }

    fun add(a:Annonce){
        saved.add(a)
        dbh.add(a)
    }

    fun getList():ArrayList<Annonce>{
        return saved
    }

    fun get(id:String): Annonce? {
        for(a in saved){
            if (a.equals(id)) return a
        }
        return null
    }
}
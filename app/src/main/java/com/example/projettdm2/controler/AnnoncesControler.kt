package com.example.projettdm2.controler

import com.example.projettdm2.model.*
import java.util.*
import kotlin.collections.ArrayList

class AnnoncesControler(var user: User,
                        var annonces: Annonces,
                        var saved: Saved,
                        var signet: Signet,
                        var preference:Preference) {

    fun getAnnonces():ArrayList<Annonce> {
        return annonces.getAnnonces()
    }

    fun getAnnonce(id:String): Annonce? {
        return annonces.getAnnonce(id)
    }

    fun loadAnnonce(date: Date, wilaya: String){
        annonces.addAnnonces(date,wilaya)
    }

    fun addSaved(a:Annonce){
        saved.add(a)
    }

    fun getListSaved():ArrayList<Annonce>{
        return saved.getList()
    }

    fun getSaved(id:String): Annonce? {
        return saved.get(id)
    }

    fun addSignet(a:Annonce){
        signet.add(a,user)
    }

    fun getListSignet():ArrayList<Annonce>{
        return signet.getList()
    }

    fun getSignet(id:String): Annonce? {
        return signet.get(id)
    }

    fun loadAnnonces(){
        signet.loadAnnonces(user)
    }

    fun login(id:String,pwd:String){
        user.login(id,pwd)
    }

    fun logout(){
        user.logout()
    }

    fun signin(id:String,pwd:String){
        user.signin(id,pwd)
    }

    fun profile():User{
        return user
    }

}
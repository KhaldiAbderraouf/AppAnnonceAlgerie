package com.example.projettdm2.model

import java.io.Serializable

class Annonce(var id:String,
              var categorie:String,
              var type:String,
              var wilaya:String,
              var Commune:String,
              var adresse:String,
              var surface:Int,
              var description:String,
              var prix:Double,
              var nom:String,
              var prenom:String,
              var adresse_annonceur:String,
              var email:String,
              var tel1:String,
              var tel2:String,
              var media:ArrayList<String>): Serializable {
    override fun equals(other: Any?): Boolean {
        if (other == this.id) return true
        return false
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 11 * result + categorie.hashCode()
        result = 11 * result + type.hashCode()
        result = 11 * result + wilaya.hashCode()
        result = 11 * result + Commune.hashCode()
        result = 11 * result + adresse.hashCode()
        result = 11 * result + surface
        result = 11 * result + description.hashCode()
        result = 11 * result + prix.hashCode()
        result = 11 * result + nom.hashCode()
        result = 11 * result + prenom.hashCode()
        result = 11 * result + adresse_annonceur.hashCode()
        result = 11 * result + email.hashCode()
        result = 11 * result + tel1.hashCode()
        result = 11 * result + tel2.hashCode()
        result = 11 * result + media.hashCode()
        return result
    }
}
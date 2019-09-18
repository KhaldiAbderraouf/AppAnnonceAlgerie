package com.example.projettdm2.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.projettdm2.model.Annonce


@Entity
data class AnnonceDB(@PrimaryKey var id:String,
                     @ColumnInfo(name = "categorie") var categorie:String,
                     @ColumnInfo(name = "type") var type:String,
                     @ColumnInfo(name = "wilaya") var wilaya:String,
                     @ColumnInfo(name = "commune") var Commune:String,
                     @ColumnInfo(name = "adresse") var adresse:String,
                     @ColumnInfo(name = "surface") var surface:Int,
                     @ColumnInfo(name = "description") var description:String,
                     @ColumnInfo(name = "prix") var prix:Double,
                     @ColumnInfo(name = "nom") var nom:String,
                     @ColumnInfo(name = "prenom") var prenom:String,
                     @ColumnInfo(name = "adresse_annonceur") var adresse_annonceur:String,
                     @ColumnInfo(name = "email") var email:String,
                     @ColumnInfo(name = "tel1") var tel1:String,
                     @ColumnInfo(name = "tel2") var tel2:String,
                     @ColumnInfo(name = "media") var media:String){
    fun to_annonce():Annonce{
        return Annonce(id,
                categorie,
                type,
                wilaya,
                Commune,
                adresse,
                surface,
                description,
                prix,
                nom,
                prenom,
                adresse_annonceur,
                email,
                tel1,
                tel2,
                to_arraylist(media))
    }

    fun to_arraylist(media: String): ArrayList<String> {
        return ArrayList(media.trim().replace("[","").replace("]","").split(","))
    }
}

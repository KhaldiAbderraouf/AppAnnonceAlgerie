package com.example.projettdm2.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import com.example.projettdm2.model.Annonce
import com.example.projettdm2.model.Saved
import org.jetbrains.anko.doAsync

class DataBaseHandler(var ctx:Context, var db:AppDatabase) {

    fun load_db(saved: Saved){
        doAsync {
            val data = db.AnnonceDBDao().getAll()
            data?.forEach {
                saved.add(it.to_annonce())
            }
            saved.update()
        }
    }

    fun add(a:Annonce){
        doAsync {
            db.AnnonceDBDao().insert(AnnonceDB(a.id,
                a.categorie,
                a.type,
                a.wilaya,
                a.Commune,
                a.adresse,
                a.surface,
                a.description,
                a.prix,
                a.nom,
                a.prenom,
                a.adresse_annonceur,
                a.email,
                a.tel1,
                a.tel2,
                a.media.toString()))
        }
    }


}

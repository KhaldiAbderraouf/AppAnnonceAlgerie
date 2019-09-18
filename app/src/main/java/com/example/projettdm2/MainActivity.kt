package com.example.projettdm2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import com.example.projettdm2.controler.AnnoncesControler
import com.example.projettdm2.controler.Preference
import com.example.projettdm2.database.AppDatabase
import com.example.projettdm2.database.DataBaseHandler
import com.example.projettdm2.model.*
import com.example.projettdm2.view.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pref = Preference(this)
        val user = pref.user

        val la = ListeAnnonceView(this)
        val lsv = ListeSavedView(this)
        val lsg = ListeSignetView(this)
        val p = Profile(this,user)

        val db = Room.databaseBuilder(
            this,
            AppDatabase::class.java, "annonce-list.db"
        ).build()

        val dbh = DataBaseHandler(this,db)

        val annonces: Subject = Annonces()
        annonces.addSubject(la)
        val saved: Subject = Saved(dbh)
        saved.addSubject(lsv)
        val signet: Subject = Signet()
        signet.addSubject(lsg)

        val c = AnnoncesControler(user, annonces as Annonces, saved as Saved, signet as Signet, pref)
        val v =  ViewGenerale(this,c,la,lsv,lsg,p)
        main.addView(v)
    }
}

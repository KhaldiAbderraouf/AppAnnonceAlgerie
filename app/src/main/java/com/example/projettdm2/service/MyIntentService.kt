package com.example.projettdm2.service

import android.app.IntentService
import android.content.Intent
import android.media.MediaPlayer
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.example.projettdm2.R
import com.example.projettdm2.controler.Preference
import com.example.projettdm2.internet.CheckSuivis
import com.example.projettdm2.internet.ICheckSuivis

class MyIntentService(var p: Preference) : IntentService("MyIntentService") {
    var cnx: ICheckSuivis = CheckSuivis()
    override fun onHandleIntent(intent: Intent?) {
        cnx.checkNew(this)
//        notif()
    }
    fun notif() {

        var builder = NotificationCompat.Builder(this, "chanel")
            .setSmallIcon(R.mipmap.ic_launcher)
            .setContentTitle("suivis")
            .setContentText("de nouvelles annonces dans la wlaya de ${p.wilaya} sont apparus")


        with(NotificationManagerCompat.from(this)) {
            notify(0, builder.build())
        }

    }

}

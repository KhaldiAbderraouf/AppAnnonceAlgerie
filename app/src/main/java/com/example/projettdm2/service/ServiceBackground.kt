package com.example.projettdm2.service

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import java.util.*

fun startAdhanService(context: Context){
    val calendar = Calendar.getInstance().apply {
        timeInMillis = System.currentTimeMillis()
        set(Calendar.HOUR_OF_DAY, 0)
        set(Calendar.MINUTE, 0)
    }

    val alarm = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
    alarm.set(
        AlarmManager.RTC_WAKEUP,
//                calendar.timeInMillis,
        System.currentTimeMillis() + 5000,
        PendingIntent.getService(context, 0, Intent(context, MyIntentService::class.java), 0)
    )
}
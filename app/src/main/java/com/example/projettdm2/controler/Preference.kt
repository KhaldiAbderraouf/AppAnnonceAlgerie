package com.example.projettdm2.controler

import android.content.Context
import com.example.projettdm2.model.User
import java.text.SimpleDateFormat
import java.util.*

class Preference(var ctx: Context) {
    var wilaya: String
    var user: User
    var date: Date
    init {
        val wilaya = ctx.getSharedPreferences("example_shared_data",
            Context.MODE_PRIVATE).getString("wilaya","alger")
        val id = ctx.getSharedPreferences("example_shared_data",
            Context.MODE_PRIVATE).getString("id","me")
        val pwd = ctx.getSharedPreferences("example_shared_data",
            Context.MODE_PRIVATE).getString("pwd","123456")
        val date = ctx.getSharedPreferences("example_shared_data",
            Context.MODE_PRIVATE).getString("date","2019-09-18")
        this.wilaya = wilaya
        user = User(id,pwd)
        val format = SimpleDateFormat("yyyy-MM-dd")
        this.date = format.parse("2019-09-18")
    }
}

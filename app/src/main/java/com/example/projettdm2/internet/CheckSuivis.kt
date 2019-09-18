package com.example.projettdm2.internet

import com.example.projettdm2.model.Annonce
import com.example.projettdm2.service.MyIntentService
import com.example.tdmrest.retroapi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CheckSuivis : ICheckSuivis {

    override fun checkNew(myIntentService: MyIntentService){
        val serveurUrl = "https://192.168.43.106:8000"
        val retrofit = Retrofit.Builder()
            .addConverterFactory(
                GsonConverterFactory.create())
            .baseUrl(serveurUrl)
            .build()
        val r = retrofit.create(retroapi::class.java)

        val annonce = r.check(myIntentService.p.wilaya,myIntentService.p.date.toString(),myIntentService.p.user.id)

        annonce.enqueue(object : Callback<Boolean> {
            override fun onResponse(call: Call<Boolean>, response: Response<Boolean>) {
                val allAnnonces = response.body()
                if (allAnnonces != null && allAnnonces) myIntentService.notif()
            }

            override fun onFailure(call: Call<Boolean>, t: Throwable) {
                error("KO")
            }
        })
    }
}

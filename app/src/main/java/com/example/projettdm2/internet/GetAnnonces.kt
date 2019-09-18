package com.example.projettdm2.internet

import com.example.projettdm2.model.Annonce
import com.example.projettdm2.model.Annonces
import com.example.tdmrest.retroapi
import java.util.*
import retrofit2.Retrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.converter.gson.GsonConverterFactory

class GetAnnonces():IGetAnnonces{
    override fun getListeAnnonces(
        date: Date,
        wilaya: String,
        annonces: Annonces
    ){
        var serveurUrl = "https://192.168.43.106:8000"
        val retrofit = Retrofit.Builder()
            .addConverterFactory(
                GsonConverterFactory.create())
            .baseUrl(serveurUrl)
            .build()

        val r = retrofit.create(retroapi::class.java)

        val annonce = r.get_annonces(date.toString(),wilaya)

        annonce.enqueue(object : Callback<List<Annonce>> {
            override fun onResponse(call: Call<List<Annonce>>, response: Response<List<Annonce>>) {
                val allAnnonces = response.body()
                if (allAnnonces != null) {
                    for (c in allAnnonces)
                        annonces.getAnnonces().add(c)
                    annonces.update()
                }
            }
            override fun onFailure(call: Call<List<Annonce>>, t: Throwable) {
                error("KO")
            }
        })
    }

}
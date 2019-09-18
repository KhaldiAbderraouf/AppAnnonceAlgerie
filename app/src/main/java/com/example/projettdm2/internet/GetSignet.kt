package com.example.projettdm2.internet

import com.example.projettdm2.model.Annonce
import com.example.projettdm2.model.Signet
import com.example.projettdm2.model.User
import com.example.tdmrest.retroapi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class GetSignet():IGetSignet {
    val serveurUrl = "https://192.168.43.106:8000"
    val retrofit = Retrofit.Builder()
        .addConverterFactory(
            GsonConverterFactory.create())
        .baseUrl(serveurUrl)
        .build()

    override fun add(user: User, a: Annonce) {
        val r = retrofit.create(retroapi::class.java)

        val annonce = r.add_signet(user.id, a.id)

        annonce.enqueue(object : Callback<Annonce> {
            override fun onResponse(call: Call<Annonce>, response: Response<Annonce>) {
                val allAnnonces = response.body()
            }

            override fun onFailure(call: Call<Annonce>, t: Throwable) {
                error("KO")
            }
        })
    }

    override fun getListeSignets(user: User, annonces: Signet) {

        val r = retrofit.create(retroapi::class.java)

        val annonce = r.get_signet(user.id)

        annonce.enqueue(object : Callback<List<Annonce>> {
            override fun onResponse(call: Call<List<Annonce>>, response: Response<List<Annonce>>) {
                val allAnnonces = response.body()
                if (allAnnonces != null) {
                    for (c in allAnnonces)
                        annonces.getList().add(c)
                    annonces.update()
                }
            }
            override fun onFailure(call: Call<List<Annonce>>, t: Throwable) {
                error("KO")
            }
        })
    }
}
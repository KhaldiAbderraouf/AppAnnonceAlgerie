package com.example.tdmrest

import com.example.projettdm2.model.Annonce
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import com.example.projettdm2.model.User
import retrofit2.http.Path
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import retrofit2.http.Field


interface retroapi {
    @GET("/annonces/{date}/{wilaya}")
    fun get_annonces(@Path("wilaya") wilaya:String,@Path("date") date:String):Call<List<Annonce>>

    @GET("/annonces/signet/{id]")
    fun get_signet(@Path("id") id:String):Call<List<Annonce>>

    @POST("/annonces/signet/new")
    fun add_signet(@Field("userId") userID: String, @Field("annonceId") annonceId: String): Call<Annonce>

    @GET("/annonces/check")
    fun check(@Field("wilaya") wilaya: String,
              @Field("date") date: String,
              @Field("id") user: String): Call<Boolean>

}

package com.example.projettdm2.model

import com.example.projettdm2.internet.GetUser
import com.example.projettdm2.internet.IGetUser

class User(var id: String, var pwd: String) {
    var cnx: IGetUser = GetUser()

    fun login(id: String, pwd: String){
        this.id = id
        this.pwd = pwd
    }

    fun signin(id: String, pwd: String){
        this.id = id
        this.pwd = pwd
    }

    fun logout(){
        this.id = ""
        this.pwd = ""
    }
}
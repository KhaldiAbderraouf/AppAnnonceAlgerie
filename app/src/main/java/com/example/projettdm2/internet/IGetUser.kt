package com.example.projettdm2.internet

interface IGetUser {
    fun login(id: String, pwd: String)

    fun signin(id: String, pwd: String)

    fun logout()
}

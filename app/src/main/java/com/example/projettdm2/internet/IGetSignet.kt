package com.example.projettdm2.internet

import com.example.projettdm2.model.Annonce
import com.example.projettdm2.model.Signet
import com.example.projettdm2.model.User
import java.util.*

interface IGetSignet {
    fun getListeSignets(
        user: User,
        annonces: Signet
    )

    fun add(user: User,a:Annonce)
}

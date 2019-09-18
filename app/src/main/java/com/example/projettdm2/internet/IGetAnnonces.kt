package com.example.projettdm2.internet

import com.example.projettdm2.model.Annonces
import java.util.*

interface IGetAnnonces {
    fun getListeAnnonces(
        date: Date,
        wilaya: String,
        annonces: Annonces
    )
}

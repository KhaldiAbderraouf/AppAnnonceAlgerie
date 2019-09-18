package com.example.projettdm2.database

import androidx.room.*

@Dao
interface AnnonceDBDao {
    @Query("SELECT * FROM AnnonceDB")
    fun getAll(): List<AnnonceDB>

    @Query("SELECT * FROM AnnonceDB WHERE id LIKE :id")
    fun findByNom(id: String): AnnonceDB

    @Insert
    fun insert(vararg todo: AnnonceDB)

    @Delete
    fun delete(todo: AnnonceDB)

    @Update
    fun update(vararg todos: AnnonceDB)
}
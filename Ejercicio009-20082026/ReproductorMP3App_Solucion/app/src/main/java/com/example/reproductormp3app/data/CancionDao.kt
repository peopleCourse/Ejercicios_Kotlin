package com.example.reproductormp3app.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

/**
 * DAO = Data Access Object.
 *
 * Analogía web: es como los endpoints de una API REST (GET /canciones,
 * POST /canciones). En vez de escribir fetch("/canciones"), aquí
 * escribimos una interfaz con anotaciones y Room genera el SQL por nosotros.
 */
@Dao
interface CancionDao {

    // Equivalente a: GET /canciones
    @Query("SELECT * FROM canciones ORDER BY id ASC")
    fun obtenerTodas(): LiveData<List<Cancion>>

    // Equivalente a: POST /canciones (varias a la vez)
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertarTodas(canciones: List<Cancion>)

    @Query("SELECT COUNT(*) FROM canciones")
    suspend fun contar(): Int
}

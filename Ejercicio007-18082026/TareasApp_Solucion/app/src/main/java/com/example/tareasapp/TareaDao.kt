package com.example.tareasapp

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

// ============================================================
// SOLUCIÓN — DAO
// ============================================================

@Dao
interface TareaDao {

    @Insert
    suspend fun insertar(tarea: Tarea)

    @Update
    suspend fun actualizar(tarea: Tarea)

    @Delete
    suspend fun eliminar(tarea: Tarea)

    @Query("SELECT * FROM tareas ORDER BY id ASC")
    fun obtenerTodas(): LiveData<List<Tarea>>
}

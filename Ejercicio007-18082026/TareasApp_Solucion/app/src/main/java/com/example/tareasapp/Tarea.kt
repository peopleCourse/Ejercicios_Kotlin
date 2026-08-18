package com.example.tareasapp

import androidx.room.Entity
import androidx.room.PrimaryKey

// ============================================================
// SOLUCIÓN — ENTITY
// ============================================================

@Entity(tableName = "tareas")
data class Tarea(

    @PrimaryKey(autoGenerate = true) val id: Int = 0,

    val descripcion: String,

    val completada: Boolean = false
)

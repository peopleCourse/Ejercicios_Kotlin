package com.example.galeriaroom.data

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Entidad Room: representa UNA fila de la tabla "images".
 *
 * Cada @Entity se traduce en una tabla SQLite.
 * Cada propiedad se traduce en una columna.
 */
@Entity(tableName = "images")
data class ImageItem(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,

    val title: String,

    val description: String,

    // Guardamos la URI de la imagen (String) en lugar del bitmap.
    // Room no puede guardar imágenes directamente: se guarda la referencia,
    // y la imagen real se pide al sistema (galería) cuando se necesita mostrar.
    val imageUri: String
)

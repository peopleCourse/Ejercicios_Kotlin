package com.example.reproductormp3app.data

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Representa una canción guardada en la base de datos.
 *
 * Analogía web: esta clase es como una fila de una tabla SQL, o como
 * el objeto que recibirías de una API REST:
 *   { id: 1, titulo: "Amanecer", artista: "Los Horizontes", ... }
 *
 * @Entity le dice a Room "esta clase representa una tabla llamada 'canciones'".
 */
@Entity(tableName = "canciones")
data class Cancion(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val titulo: String,
    val artista: String,
    val duracionTexto: String,  // ej. "00:14", solo para mostrarlo en la lista
    val audioResId: Int,        // recurso en res/raw (el archivo .mp3 de la canción)archivosmp3/cancion01.mp3
    val imagenResId: Int        // recurso en res/drawable (la carátula de esa canción) arcimagen/caratura.jpg
)

package com.example.reproductormp3app.data

import androidx.lifecycle.LiveData

/**
 * El repositorio es una capa intermedia entre el ViewModel y el DAO.
 *
 * Analogía web: es como un archivo `api.js` que centraliza las llamadas
 * fetch() en un solo lugar, en vez de que cada pantalla hable directo
 * con la base de datos.
 */
class CancionRepository(private val dao: CancionDao) {

    val todasLasCanciones: LiveData<List<Cancion>> = dao.obtenerTodas()

    suspend fun insertarTodas(canciones: List<Cancion>) {
        dao.insertarTodas(canciones)
    }
}

package com.example.reproductormp3app.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.reproductormp3app.data.AppDatabase
import com.example.reproductormp3app.data.Cancion
import com.example.reproductormp3app.data.CancionRepository

/**
 * ViewModel: sobrevive a cambios de configuración (como rotar la pantalla)
 * y expone los datos observables a la Activity.
 *
 * Analogía web: se parece a un "store" (Redux/Pinia) que guarda el estado
 * y avisa a la UI cuando cambia, en vez de que la UI consulte la base de
 * datos directamente cada vez.
 */
class CancionViewModel(application: Application) : AndroidViewModel(application) {

    private val repositorio: CancionRepository
    val canciones: LiveData<List<Cancion>>

    init {
        val dao = AppDatabase.getInstance(application).cancionDao()
        repositorio = CancionRepository(dao)
        canciones = repositorio.todasLasCanciones
    }
}

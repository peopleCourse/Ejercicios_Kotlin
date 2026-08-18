package com.example.tareasapp

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

// ============================================================
// SOLUCIÓN — VIEWMODEL
// ============================================================

class TareaViewModel(application: Application) : AndroidViewModel(application) {

    private val dao = AppDatabase.getDatabase(application).tareaDao()

    val tareas: LiveData<List<Tarea>> = dao.obtenerTodas()

    fun agregarTarea(descripcion: String) {
        viewModelScope.launch {
            dao.insertar(Tarea(descripcion = descripcion))
        }
    }

    fun actualizarTarea(tarea: Tarea) {
        viewModelScope.launch {
            dao.actualizar(tarea)
        }
    }

    fun eliminarTarea(tarea: Tarea) {
        viewModelScope.launch {
            dao.eliminar(tarea)
        }
    }
}

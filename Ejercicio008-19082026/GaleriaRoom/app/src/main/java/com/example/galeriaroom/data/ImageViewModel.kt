package com.example.galeriaroom.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

/**
 * ViewModel: sobrevive a los cambios de configuración (por ejemplo,
 * girar la pantalla) y expone los datos a la UI mediante LiveData.
 *
 * La Activity/Fragment NUNCA debe hablar directamente con el DAO:
 * siempre pasa por aquí.
 */
class ImageViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: ImageRepository

    // LiveData que la UI observa. Cada vez que la tabla cambia,
    // este LiveData emite la lista actualizada automáticamente.
    val allImages: LiveData<List<ImageItem>>

    init {
        val dao = AppDatabase.getDatabase(application).imageDao()
        repository = ImageRepository(dao)
        allImages = repository.allImages.asLiveData()
    }

    fun insert(image: ImageItem) = viewModelScope.launch {
        repository.insert(image)
    }

    fun delete(image: ImageItem) = viewModelScope.launch {
        repository.delete(image)
    }
}

/**
 * Factory necesaria porque ImageViewModel tiene un parámetro (Application)
 * en su constructor. Sin esta clase, el sistema no sabría cómo crearlo.
 */
class ImageViewModelFactory(private val application: Application) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ImageViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ImageViewModel(application) as T
        }
        throw IllegalArgumentException("ViewModel desconocido")
    }
}

package com.example.galeriaroom.data

import kotlinx.coroutines.flow.Flow

/**
 * Repositorio: capa intermedia entre el DAO y el ViewModel.
 *
 * No es estrictamente obligatorio en un ejercicio tan sencillo, pero se
 * incluye porque es la arquitectura recomendada por Google (separar el
 * origen de datos de la lógica de la UI). Facilita, por ejemplo, añadir
 * en el futuro otra fuente de datos (una API) sin tocar el ViewModel.
 */
class ImageRepository(private val imageDao: ImageDao) {

    val allImages: Flow<List<ImageItem>> = imageDao.getAllImages()

    suspend fun insert(image: ImageItem) {
        imageDao.insertImage(image)
    }

    suspend fun delete(image: ImageItem) {
        imageDao.deleteImage(image)
    }
}

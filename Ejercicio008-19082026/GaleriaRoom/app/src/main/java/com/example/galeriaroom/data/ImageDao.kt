package com.example.galeriaroom.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

/**
 * DAO (Data Access Object): define QUÉ operaciones se pueden hacer
 * sobre la tabla "images". Room genera el código SQL por nosotros.
 *
 * Todas las funciones son "suspend" o devuelven Flow porque el acceso
 * a la base de datos NUNCA debe hacerse en el hilo principal (UI).
 */
@Dao
interface ImageDao {

    // Flow -> la lista se actualiza automáticamente en la UI
    // cada vez que cambian los datos en la tabla (sin recargar a mano).
    @Query("SELECT * FROM images ORDER BY id DESC")
    fun getAllImages(): Flow<List<ImageItem>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertImage(image: ImageItem)

    @Delete
    suspend fun deleteImage(image: ImageItem)
}

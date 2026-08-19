package com.example.galeriaroom.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

/**
 * Clase abstracta que representa la base de datos completa.
 * Room genera automáticamente la implementación real en tiempo de compilación.
 *
 * Se usa el patrón Singleton para asegurar que exista UNA sola
 * instancia de la base de datos en toda la app.
 */
@Database(entities = [ImageItem::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun imageDao(): ImageDao

    companion object {
        // @Volatile garantiza que los cambios sean visibles inmediatamente
        // para todos los hilos (evita condiciones de carrera).
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "galeria_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}

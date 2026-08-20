package com.example.reproductormp3app.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.reproductormp3app.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * Punto de entrada a la base de datos.
 *
 * Analogía web: es como abrir la conexión a una BD (o inicializar
 * localStorage la primera vez), pero Room nos da un objeto con el que
 * trabajar en vez de tener que escribir SQL a mano.
 */
@Database(entities = [Cancion::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun cancionDao(): CancionDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        // Patrón Singleton: solo debe existir UNA instancia de la base de datos
        // en toda la app (parecido a un solo objeto "db" compartido en JS).
        fun getInstance(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instancia = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "reproductor_mp3_db"
                ).build()
                INSTANCE = instancia
                prepoblarSiEstaVacia(instancia)
                instancia
            }
        }

        // La primera vez que se abre la app, cargamos 5 canciones de ejemplo
        // (como un "seed" de datos iniciales).
        private fun prepoblarSiEstaVacia(db: AppDatabase) {
            CoroutineScope(Dispatchers.IO).launch {
                if (db.cancionDao().contar() == 0) {
                    db.cancionDao().insertarTodas(cancionesSemilla())
                }
            }
        }

        private fun cancionesSemilla(): List<Cancion> {
            return listOf(
                Cancion(
                    titulo = "Amanecer", artista = "Los Horizontes", duracionTexto = "00:14",
                    audioResId = R.raw.amanecer, imagenResId = R.drawable.amanecer
                ),
                Cancion(
                    titulo = "Ciudad de Cristal", artista = "Nova Luna", duracionTexto = "00:18",
                    audioResId = R.raw.ciudad_de_cristal, imagenResId = R.drawable.ciudad_de_cristal
                ),
                Cancion(
                    titulo = "Ritmo del Río", artista = "Trío Andino", duracionTexto = "00:16",
                    audioResId = R.raw.ritmo_del_rio, imagenResId = R.drawable.ritmo_del_rio
                ),
                Cancion(
                    titulo = "Noches de Neón", artista = "Synth Waves", duracionTexto = "00:20",
                    audioResId = R.raw.noches_de_neon, imagenResId = R.drawable.noches_de_neon
                ),
                Cancion(
                    titulo = "Camino al Sur", artista = "Raíces", duracionTexto = "00:15",
                    audioResId = R.raw.camino_al_sur, imagenResId = R.drawable.camino_al_sur
                )
            )
        }
    }
}

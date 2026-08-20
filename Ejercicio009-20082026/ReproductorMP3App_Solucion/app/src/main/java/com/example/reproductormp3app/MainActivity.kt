package com.example.reproductormp3app

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.reproductormp3app.databinding.ActivityMainBinding
import com.example.reproductormp3app.ui.CancionAdapter
import com.example.reproductormp3app.ui.CancionViewModel

/**
 * Pantalla principal: muestra la lista de canciones guardadas en Room.
 * Al tocar una canción, abre PlayerActivity para reproducirla.
 */
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: CancionAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModel = ViewModelProvider(this)[CancionViewModel::class.java]

        adapter = CancionAdapter(emptyList()) { cancion ->
            val intent = Intent(this, PlayerActivity::class.java).apply {
                putExtra(PlayerActivity.EXTRA_TITULO, cancion.titulo)
                putExtra(PlayerActivity.EXTRA_ARTISTA, cancion.artista)
                putExtra(PlayerActivity.EXTRA_AUDIO_RES_ID, cancion.audioResId)
                putExtra(PlayerActivity.EXTRA_IMAGEN_RES_ID, cancion.imagenResId)
            }
            startActivity(intent)
        }

        binding.rvCanciones.layoutManager = LinearLayoutManager(this)
        binding.rvCanciones.adapter = adapter

        // Observamos el LiveData: cada vez que cambien los datos en Room,
        // esta lambda se ejecuta automáticamente con la lista actualizada.
        viewModel.canciones.observe(this) { listaCanciones ->
            adapter.actualizarLista(listaCanciones)
        }
    }
}

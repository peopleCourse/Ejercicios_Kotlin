package com.example.tareasapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tareasapp.databinding.ActivityMainBinding

// ============================================================
// SOLUCIÓN — MAINACTIVITY
// ============================================================

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: TareaAdapter

    private val viewModel: TareaViewModel by lazy {
        ViewModelProvider(this)[TareaViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = TareaAdapter(
            tareas = emptyList(),
            onCompletadaChanged = { tarea -> viewModel.actualizarTarea(tarea) },
            onEliminarClick = { tarea -> viewModel.eliminarTarea(tarea) }
        )

        binding.rvTareas.layoutManager = LinearLayoutManager(this)
        binding.rvTareas.adapter = adapter

        viewModel.tareas.observe(this) { lista ->
            adapter.actualizarLista(lista)
        }

        binding.btnAgregar.setOnClickListener {
            val texto = binding.etNuevaTarea.text.toString().trim()
            if (texto.isNotEmpty()) {
                viewModel.agregarTarea(texto)
                binding.etNuevaTarea.text.clear()
            }
        }
    }
}

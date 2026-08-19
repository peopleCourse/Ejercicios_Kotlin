package com.example.galeriaroom

import android.app.Application
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.galeriaroom.data.ImageViewModel
import com.example.galeriaroom.data.ImageViewModelFactory
import com.example.galeriaroom.databinding.ActivityMainBinding
import com.example.galeriaroom.ui.ImageAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    // Se crea con la Factory porque el ViewModel necesita "Application"
    private val viewModel: ImageViewModel by lazy {
        ImageViewModelFactory(application)
            .create(ImageViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = ImageAdapter(onLongClick = { item ->
            AlertDialog.Builder(this)
                .setTitle("Eliminar imagen")
                .setMessage("¿Eliminar \"${item.title}\"?")
                .setPositiveButton("Eliminar") { _, _ -> viewModel.delete(item) }
                .setNegativeButton("Cancelar", null)
                .show()
        })

        binding.recyclerView.layoutManager = GridLayoutManager(this, 2)
        binding.recyclerView.adapter = adapter

        // Observamos el LiveData: cada vez que Room notifica un cambio
        // en la tabla, este bloque se ejecuta con la lista actualizada.
        viewModel.allImages.observe(this) { images ->
            adapter.submitList(images)
            binding.tvEmpty.visibility =
                if (images.isEmpty()) android.view.View.VISIBLE else android.view.View.GONE
        }

        binding.fabAdd.setOnClickListener {
            startActivity(Intent(this, AddImageActivity::class.java))
        }
    }
}

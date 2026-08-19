package com.example.galeriaroom

import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.galeriaroom.data.ImageItem
import com.example.galeriaroom.data.ImageViewModel
import com.example.galeriaroom.data.ImageViewModelFactory
import com.example.galeriaroom.databinding.ActivityAddImageBinding

class AddImageActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddImageBinding
    private var selectedUri: Uri? = null

    private val viewModel: ImageViewModel by lazy {
        ImageViewModelFactory(application).create(ImageViewModel::class.java)
    }

    // Selector moderno de imágenes: no requiere pedir permisos en tiempo
    // de ejecución (ideal para explicar en clase sin complicar el ejercicio).
    private val pickImageLauncher = registerForActivityResult(
        ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        if (uri != null) {
            selectedUri = uri
            Glide.with(this).load(uri).centerCrop().into(binding.ivPreview)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddImageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ivPreview.setOnClickListener {
            pickImageLauncher.launch("image/*")
        }

        binding.btnSave.setOnClickListener {
            guardarImagen()
        }
    }

    private fun guardarImagen() {
        val title = binding.etTitle.text.toString().trim()
        val description = binding.etDescription.text.toString().trim()
        val uri = selectedUri

        if (uri == null) {
            Toast.makeText(this, "Selecciona una imagen", Toast.LENGTH_SHORT).show()
            return
        }
        if (title.isEmpty()) {
            Toast.makeText(this, "Escribe un título", Toast.LENGTH_SHORT).show()
            return
        }

        // Persistimos el permiso de lectura sobre la URI: sin esto,
        // la URI dejaría de ser válida al reiniciar la app.
        contentResolver.takePersistableUriPermission(
            uri, android.content.Intent.FLAG_GRANT_READ_URI_PERMISSION
        )

        viewModel.insert(
            ImageItem(
                title = title,
                description = description,
                imageUri = uri.toString()
            )
        )
        finish()
    }
}

package com.example.galeriaroom.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.galeriaroom.data.ImageItem
import com.example.galeriaroom.databinding.ItemImageBinding

/**
 * ListAdapter + DiffUtil: cuando el Flow del DAO emite una nueva lista,
 * este adapter calcula automáticamente QUÉ elementos cambiaron y
 * anima solo esos cambios (en vez de redibujar toda la lista).
 */
class ImageAdapter(
    private val onLongClick: (ImageItem) -> Unit
) : ListAdapter<ImageItem, ImageAdapter.ImageViewHolder>(DiffCallback) {

    inner class ImageViewHolder(val binding: ItemImageBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val binding = ItemImageBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ImageViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        val item = getItem(position)
        holder.binding.tvTitle.text = item.title
        holder.binding.tvDescription.text = item.description

        // Glide carga la imagen a partir de la URI guardada en Room.
        Glide.with(holder.itemView.context)
            .load(item.imageUri)
            .centerCrop()
            .into(holder.binding.ivImage)

        // Mantener pulsado un elemento -> eliminarlo (para practicar @Delete)
        holder.itemView.setOnLongClickListener {
            onLongClick(item)
            true
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<ImageItem>() {
        override fun areItemsTheSame(oldItem: ImageItem, newItem: ImageItem) =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: ImageItem, newItem: ImageItem) =
            oldItem == newItem
    }
}

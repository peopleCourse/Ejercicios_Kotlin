package com.example.reproductormp3app.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.reproductormp3app.data.Cancion
import com.example.reproductormp3app.databinding.ItemCancionBinding

/**
 * Adapter: "traduce" cada Cancion de la lista a una fila visual (item_cancion.xml).
 *
 * Analogía web: es lo mismo que un .map() sobre un array de datos que
 * genera un <div> por cada elemento, pero optimizado para reciclar vistas.
 */
class CancionAdapter(
    private var canciones: List<Cancion>,
    private val onClick: (Cancion) -> Unit
) : RecyclerView.Adapter<CancionAdapter.CancionViewHolder>() {

    inner class CancionViewHolder(val binding: ItemCancionBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CancionViewHolder {
        val binding = ItemCancionBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CancionViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CancionViewHolder, position: Int) {
        val cancion = canciones[position]
        holder.binding.tvTituloCancion.text = cancion.titulo
        holder.binding.tvArtista.text = cancion.artista
        holder.binding.tvDuracion.text = cancion.duracionTexto
        holder.binding.ivCaratula.setImageResource(cancion.imagenResId)
        holder.binding.root.setOnClickListener { onClick(cancion) }
    }

    override fun getItemCount(): Int = canciones.size

    fun actualizarLista(nuevaLista: List<Cancion>) {
        canciones = nuevaLista
        notifyDataSetChanged()
    }
}

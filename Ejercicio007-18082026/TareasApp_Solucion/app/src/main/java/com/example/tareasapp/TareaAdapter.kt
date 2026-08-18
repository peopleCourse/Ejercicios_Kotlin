package com.example.tareasapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tareasapp.databinding.ItemTareaBinding

// ============================================================
// SOLUCIÓN — ADAPTER
// ============================================================

class TareaAdapter(
    private var tareas: List<Tarea>,
    private val onCompletadaChanged: (Tarea) -> Unit,
    private val onEliminarClick: (Tarea) -> Unit
) : RecyclerView.Adapter<TareaAdapter.TareaViewHolder>() {

    inner class TareaViewHolder(val binding: ItemTareaBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TareaViewHolder {
        val binding = ItemTareaBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return TareaViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TareaViewHolder, position: Int) {
        val tarea = tareas[position]

        holder.binding.tvDescripcion.text = tarea.descripcion
        holder.binding.cbCompletada.setOnCheckedChangeListener(null)
        holder.binding.cbCompletada.isChecked = tarea.completada

        holder.binding.cbCompletada.setOnCheckedChangeListener { _, isChecked ->
            onCompletadaChanged(tarea.copy(completada = isChecked))
        }

        holder.binding.btnEliminar.setOnClickListener {
            onEliminarClick(tarea)
        }
    }

    override fun getItemCount(): Int = tareas.size

    fun actualizarLista(nuevaLista: List<Tarea>) {
        tareas = nuevaLista
        notifyDataSetChanged()
    }
}

package com.example.android_ejercicios_xml.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android_ejercicios_xml.databinding.MensajesCeldasBinding
import com.example.android_ejercicios_xml.domain.models.Mensaje

class MensajeAdapter(val mensajes: MutableList<Mensaje> = mutableListOf()) :
    RecyclerView.Adapter<MensajeAdapter.ViewHolder>() {
    class ViewHolder(val itemBinding: MensajesCeldasBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(mensaje: Mensaje) {
            itemBinding.textView.text = mensaje.mensaje.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemBinding =
            MensajesCeldasBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(mensajes.get(position))
    }

    override fun getItemCount(): Int {
        return mensajes.size
    }
    fun agregarMensajes(mensajesDelServidor:List<Mensaje>){
        mensajes.addAll(mensajesDelServidor)
        notifyDataSetChanged()
    }
    fun agregarMensajes(mensaje:Mensaje) {
        mensajes.add(mensaje)
        notifyDataSetChanged()
    }
}
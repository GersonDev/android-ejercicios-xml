package com.example.android_ejercicios_xml

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android_ejercicios_xml.databinding.CronogramaCeldasBinding
import com.example.android_ejercicios_xml.databinding.FragmentSecondBinding
import com.example.android_ejercicios_xml.domain.models.Cronograma

class CronogramaAdapter(val cronogramas: List<Cronograma>) :
    RecyclerView.Adapter<CronogramaAdapter.ViewHolder>() {
    class ViewHolder(val itemBinding: CronogramaCeldasBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(cronograma: Cronograma) {
            itemBinding.vencimientoTextView.text = cronograma.vencimiento.toString()
            itemBinding.InteresTextView.text = String.format("%.2f",cronograma.interes)
            itemBinding.cuotaTextView.text = String.format("%.2f",cronograma.cuota)
            itemBinding.saldoTextView.text = String.format("%.1f",cronograma.saldo)
            itemBinding.segurosTextView.text = cronograma.seguros.toString()
            itemBinding.subvencionTextView.text = cronograma.subvencion.toString()
            itemBinding.amortizacionTextView.text = String.format("%.2f",cronograma.amortizacion)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemBinding =
            CronogramaCeldasBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(cronogramas.get(position))
    }

    override fun getItemCount(): Int {
        return cronogramas.size
    }
}
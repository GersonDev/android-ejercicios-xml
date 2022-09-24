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
            itemBinding.InteresTextView.text = cronograma.interes.toString()
            itemBinding.cuotaTextView.text = cronograma.cuota.toString()
            itemBinding.saldoTextView.text = cronograma.saldo.toString()
            itemBinding.segurosTextView.text = cronograma.seguros.toString()
            itemBinding.subvencionTextView.text = cronograma.subvencion.toString()
            itemBinding.vencimientoTextView.text = cronograma.vencimiento.toString()
            itemBinding.amortizacionTextView.text = cronograma.amortizacion.toString()
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
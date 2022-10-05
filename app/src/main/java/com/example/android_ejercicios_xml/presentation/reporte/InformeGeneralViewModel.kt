package com.example.android_ejercicios_xml.presentation.reporte

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.android_ejercicios_xml.data.preferences.Preferences
import com.example.android_ejercicios_xml.domain.repositories.ClientesRepository
import com.example.android_ejercicios_xml.domain.repositories.CuentasRepository
import com.example.android_ejercicios_xml.domain.repositories.MovimientosRepository

class InformeGeneralViewModel(val app:Application):AndroidViewModel(app) {

    private val preferences = Preferences(app)
    private val clientesRepository: ClientesRepository = ClientesRepository()
    private val cuentasRepository: CuentasRepository = CuentasRepository()
    private val movimientosRepository = MovimientosRepository()



    fun registrarInformeGeneral (){

        val clienteEncontrado=clientesRepository.getCliente()
    }
}
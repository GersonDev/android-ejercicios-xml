package com.example.android_ejercicios_xml.presentation.movimiento

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.android_ejercicios_xml.data.preferences.Preferences
import com.example.android_ejercicios_xml.domain.models.Movimiento
import com.example.android_ejercicios_xml.domain.repositories.MovimientosRepository
import kotlinx.coroutines.launch

class MovimientoViewModel(val app: Application) : AndroidViewModel(app) {

    val preferences = Preferences(app)

    private val _dni = MutableLiveData("")
    val dni: LiveData<String> = _dni
    private val _tipoDeOperacion = MutableLiveData("")
    val tipoDeOperacion: LiveData<String> = _tipoDeOperacion
    private val _importe = MutableLiveData("")
    val importe: LiveData<String> = _importe
    private val _descripcion = MutableLiveData("")
    val descripcion: LiveData<String> = _descripcion

    private val movimientosRepository = MovimientosRepository()

    fun enviarDni(dni: String) {
        _dni.value = dni
    }

    fun enviarTipoDeOperacion(tipoDeOperacion: String) {
        _tipoDeOperacion.value = tipoDeOperacion
    }

    fun enviarimporte(importe: String) {
        _importe.value = importe
    }

    fun enviardescripcion(descripcion: String) {
        _descripcion.value = descripcion
    }
    fun registarMovimientos(){

        val numeroDeOperacionAleatorio = (100000..200000).random()

        val movimiento = Movimiento(
            numeroDeOperacion = "$numeroDeOperacionAleatorio".toInt(),
            fechaOperacion = ,
            descripcion =_descripcion.value.toString() ,
            numeroDeCuenta =preferences.getNumeroDeCuenta() ,
            tipoDeOperacion =_tipoDeOperacion.value.toString(),
            importe =_importe.value?.toDouble()?:0.0 ,
            saldoContable = ,
        )
        viewModelScope.launch {

            movimientosRepository.insertMovimiento(app,movimiento)
        }
    }
}

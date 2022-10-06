package com.example.android_ejercicios_xml.presentation.movimiento

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.android_ejercicios_xml.data.preferences.Preferences
import com.example.android_ejercicios_xml.domain.models.Movimiento
import com.example.android_ejercicios_xml.domain.repositories.ClientesRepository
import com.example.android_ejercicios_xml.domain.repositories.CuentasRepository
import com.example.android_ejercicios_xml.domain.repositories.MovimientosRepository
import kotlinx.coroutines.launch
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class MovimientoViewModel(val app: Application) : AndroidViewModel(app) {

    private val preferences = Preferences(app)
    private val clientesRepository: ClientesRepository = ClientesRepository()
    private val cuentasRepository: CuentasRepository = CuentasRepository()
    private val movimientosRepository = MovimientosRepository()


    private val _tipoDeOperacion = MutableLiveData("")
    val tipoDeOperacion: LiveData<String> = _tipoDeOperacion
    private val _importe = MutableLiveData("")
    val importe: LiveData<String> = _importe
    private val _descripcion = MutableLiveData("")
    val descripcion: LiveData<String> = _descripcion


    fun enviarTipoDeOperacion(tipoDeOperacion: String) {
        _tipoDeOperacion.value = tipoDeOperacion
    }

    fun enviarimporte(importe: String) {
        _importe.value = importe
    }

    fun enviardescripcion(descripcion: String) {
        _descripcion.value = descripcion
    }

    fun registarMovimientos() {

        viewModelScope.launch {
            val numeroDeOperacionAleatorio = (100000..200000).random()

            val dateTime = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))

            val cuentaEncontrada = cuentasRepository.getCuentaPorDNI(app, preferences.getdni())

            var saldoContable = 0.0

            if (tipoDeOperacion.value == "Deposito") {
                saldoContable = cuentaEncontrada.saldoActual + _importe.value?.toDouble()!!
            } else {
                if (saldoContable - _importe.value?.toDouble()!!<0){
                    "// mandar mensaje"
                }else{
                    saldoContable = cuentaEncontrada.saldoActual - _importe.value?.toDouble()!!
                }
            }


            val movimiento = Movimiento(
                numeroDeOperacion = "$numeroDeOperacionAleatorio".toInt(),
                fechaOperacion = dateTime,
                descripcion = _descripcion.value.toString(),
                numeroDeCuenta = preferences.getNumeroDeCuenta(),
                tipoDeOperacion = _tipoDeOperacion.value.toString(),
                importe = _importe.value?.toDouble() ?: 0.0,
                saldoContable = saldoContable,
            )
            movimientosRepository.insertMovimiento(app, movimiento)
        }
    }
}

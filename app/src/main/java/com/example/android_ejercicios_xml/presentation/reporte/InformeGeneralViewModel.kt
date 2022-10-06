package com.example.android_ejercicios_xml.presentation.reporte

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.android_ejercicios_xml.data.preferences.Preferences
import com.example.android_ejercicios_xml.domain.repositories.ClientesRepository
import com.example.android_ejercicios_xml.domain.repositories.CuentasRepository
import com.example.android_ejercicios_xml.domain.repositories.MovimientosRepository
import kotlinx.coroutines.launch

class InformeGeneralViewModel(val app: Application) : AndroidViewModel(app) {

    private val preferences = Preferences(app)
    private val clientesRepository: ClientesRepository = ClientesRepository()
    private val cuentasRepository: CuentasRepository = CuentasRepository()
    private val movimientosRepository = MovimientosRepository()

    private val _numeroDeCuenta = MutableLiveData("")
    val numeroDeCuenta: LiveData<String> = _numeroDeCuenta
    private val _informeGeneral = MutableLiveData("")
    val informeGeneral: LiveData<String> = _informeGeneral


    fun registrarInformeGeneral(numeroDeCuenta: Int) {

        viewModelScope.launch {
            val clienteEncontrado = clientesRepository.getClientePorDNI(app, preferences.getdni())

            val cuentaEncontrada = cuentasRepository.getCuentaPorNumeroDeCuenta(app, numeroDeCuenta)

            val movimientoEncontrado = movimientosRepository.getMovimientoPorNumeroDeCuenta(app, numeroDeCuenta)

            var movimientos = ""

            movimientoEncontrado.forEach {
                movimientos +="${it.numeroDeCuenta}   ${it.fechaOperacion} ${it.descripcion} ${it.numeroDeOperacion} ${it.tipoDeOperacion} ${it.importe} ${it.saldoContable} \n"
            }

            _informeGeneral.value = "Cliente:${clienteEncontrado.nombreCliente}\n" +
                    "Direccion:${clienteEncontrado.direccion}\n" +
                    "Distrito:${clienteEncontrado.distrito}\n\n" +
                    "Numero de Cuenta:${cuentaEncontrada.numeroDeCuenta}\n" +
                    "Tipo de Cuneta: ${cuentaEncontrada.tipoDeCuenta}\n" +
                    "Moneda: ${cuentaEncontrada.moneda}\n" +
                    "Saldo Actual: ${cuentaEncontrada.saldoActual}\n\n" +
                    "Movimientos\n\n" +
                    "NumeroCuenta  Fecha  Descripcion  Numero  Tipo  Importe Saldo\n" +
                    "                           Operacion                 OperacionOperacion   Contable\n" +
                    movimientos
        }

    }
}
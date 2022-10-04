package com.example.android_ejercicios_xml.presentation.cuenta

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.android_ejercicios_xml.data.preferences.Preferences
import com.example.android_ejercicios_xml.domain.models.Cuenta
import com.example.android_ejercicios_xml.domain.repositories.CuentasRepository
import kotlinx.coroutines.launch

class RegistroNumeroDeCuentaViewModel(val app: Application) : AndroidViewModel(app) {


    val preferences = Preferences(app)

    private val _tipoDeCuenta = MutableLiveData("")
    val tipoDeCuenta: LiveData<String> = _tipoDeCuenta
    private val _moneda = MutableLiveData("")
    val moneda: LiveData<String> = _moneda
    private val _saldo = MutableLiveData("")
    val saldo: LiveData<String> = _saldo


    private val cuentasRepository = CuentasRepository()

    fun enviarTipoDeCuenta(tipoDeCuenta: String) {
        _tipoDeCuenta.value = tipoDeCuenta
    }

    fun enviarMoneda(moneda: String) {
        _moneda.value = moneda
    }

    fun enviarSaldo(saldo: String) {
        _saldo.value = saldo
    }

    fun registrarCuenta() {

        val numeroDeCuentaAleatorio = (1000000000..2000000000).random()

        val cuenta = Cuenta(
            numeroDeCuenta = "$numeroDeCuentaAleatorio".toInt(),
            tipoDeCuenta = _tipoDeCuenta.value ?: "",
            moneda = _moneda.value ?: "",
            saldoActual = _saldo.value?.toDouble() ?: 0.0,
            dni = preferences.getdni()
        )
        viewModelScope.launch {
            preferences.saveNumeroDeCuenta(numeroDeCuentaAleatorio)
            cuentasRepository.insertCuenta(app, cuenta)
        }
    }
}
package com.example.android_ejercicios_xml.presentation.cliente

import android.app.Application
import androidx.lifecycle.*
import com.example.android_ejercicios_xml.data.preferences.Preferences
import com.example.android_ejercicios_xml.domain.models.Cliente
import com.example.android_ejercicios_xml.domain.repositories.ClientesRepository
import kotlinx.coroutines.launch

class RegistroClienteViewModel(val app: Application) : AndroidViewModel(app) {

    val preferences = Preferences(app)

    private val _dni = MutableLiveData("")
    val dni: LiveData<String> = _dni
    private val _nombre = MutableLiveData("")
    val nombre: LiveData<String> = _nombre
    private val _direccion = MutableLiveData("")
    val direccion: LiveData<String> = _direccion
    private val _distrito = MutableLiveData("")
    val distrito: LiveData<String> = _distrito

    private val clientesRepository = ClientesRepository()

    fun enviarDni(dni: String) {
        _dni.value = dni
    }

    fun enviarNombre(nombre: String) {
        _nombre.value = nombre
    }

    fun enviarDireccion(direccion: String) {
        _direccion.value = direccion
    }

    fun enviarDistrito(distrito: String) {
        _distrito.value = distrito
    }

    fun registrarCliente() {
        val cliente = Cliente(
            dni = _dni.value?.toInt() ?: 0,
            nombreCliente = _nombre.value ?: "",
            direccion = _direccion.value ?: "",
            distrito = _distrito.value ?: ""
        )
        viewModelScope.launch {
            preferences.saveDNI(dni.value!!.toInt())
            clientesRepository.insertCliente(app, cliente)
        }
    }
}
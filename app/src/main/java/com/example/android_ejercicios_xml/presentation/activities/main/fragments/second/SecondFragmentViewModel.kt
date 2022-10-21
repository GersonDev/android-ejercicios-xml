package com.example.android_ejercicios_xml.presentation.activities.main.fragments.second

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.android_ejercicios_xml.domain.models.Mensaje
import com.example.android_ejercicios_xml.domain.repositories.MensajesRepository
import kotlinx.coroutines.launch

class SecondFragmentViewModel(
    val app: Application,
    val mensajesRepository: MensajesRepository
    ) : AndroidViewModel(app) {

    private val _mensajesMutableLiveData = MutableLiveData<List<Mensaje>>(emptyList())
    val mensajesLiveData: LiveData<List<Mensaje>> = _mensajesMutableLiveData

    private val _mensajesDelServidor = MutableLiveData("")
    val mensajesDelServidor: LiveData<String> = _mensajesDelServidor


    //se envia el datos mensaje al repositorio
    fun enviarMensaje(mensaje: String) {
    //viewmodelscope sirve para ejecutar funciones suspendidas.
        viewModelScope.launch {
            mensajesRepository.sendMensajesFromRemote(mensaje = mensaje)
            _mensajesDelServidor.value = "el mensaje fue enviado"
        }
    }

    fun getMensajes() {
        viewModelScope.launch {
            val mensajes = mensajesRepository.getMensajesFromRemote()
            _mensajesMutableLiveData.value = mensajes
        }
    }
}
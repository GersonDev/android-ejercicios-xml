package com.example.android_ejercicios_xml.data.datasources

import com.example.android_ejercicios_xml.data.ApiClient
import com.example.android_ejercicios_xml.data.requests.MensajeRequest
import com.example.android_ejercicios_xml.domain.models.Mensaje

class RemoteDataSource {
    suspend fun getMensajesFromRemote(): List<Mensaje> {
        val mensajeReponse = ApiClient.getClient().getMensajes()
        val mensajes = mensajeReponse.map {
            Mensaje(
                mensaje = it.mensaje
            )
        }
        return mensajes
    }

    suspend fun sendMensjaesFromRemote(mensaje: String) {
        ApiClient.getClient().createBrand(
            MensajeRequest(mensaje)
        )
    }
}
package com.example.android_ejercicios_xml.domain.repositories

import com.example.android_ejercicios_xml.data.datasources.RemoteDataSource
import com.example.android_ejercicios_xml.domain.models.Mensaje
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MensajesRepository(
    private val remoteDataSource: RemoteDataSource
) {

    suspend fun getMensajesFromRemote(): List<Mensaje> {
        //withcontext sirve para ejecutar una funcion en un hilo secundario.
        return withContext(Dispatchers.IO) {
            remoteDataSource.getMensajesFromRemote()
        }
    }

    suspend fun sendMensajesFromRemote(mensaje: String) {
        withContext(Dispatchers.IO) {
            remoteDataSource.sendMensjaesFromRemote(mensaje = mensaje)
        }
    }
}
package com.example.android_ejercicios_xml.data.datasources

import android.content.Context
import com.example.android_ejercicios_xml.data.database.entities.ClienteEntity
import com.example.android_ejercicios_xml.data.database.entities.LineaUnoDataBase
import com.example.android_ejercicios_xml.domain.models.Cliente

class DatabaseDataSource {
    suspend fun getAllTheClientes(context: Context): List<Cliente>{
        val listOfClienteEntities = LineaUnoDataBase.buildDatabase(context)
            .clientesDao()
            .getClientes()
        return listOfClienteEntities.map {
            Cliente(
                dni = it.dni,
                nombreCliente = it.nombreCliente,
                direccion = it.direccion,
                distrito = it.distrito
            )
        }
    }
    suspend fun insertCliente(context: Context,cliente: Cliente){
        val clienteEntity = ClienteEntity(
            dni = cliente.dni,
            nombreCliente = cliente.nombreCliente,
            direccion = cliente.direccion,
            distrito = cliente.distrito
        )
        LineaUnoDataBase.buildDatabase(context)
            .clientesDao()
            .insertCliente(clienteEntity)
    }
}
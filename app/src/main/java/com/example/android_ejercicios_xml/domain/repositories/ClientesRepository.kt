package com.example.android_ejercicios_xml.domain.repositories

import android.content.Context
import com.example.android_ejercicios_xml.data.datasources.DatabaseDataSource
import com.example.android_ejercicios_xml.domain.models.Cliente
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ClientesRepository {
    private val databaseDataSource = DatabaseDataSource()


    suspend fun getAllTheClientes(context: Context): List<Cliente> {
        return withContext(Dispatchers.IO) {
            databaseDataSource.getAllTheClientes(context)
        }
    }

    suspend fun insertCliente(context: Context, cliente: Cliente) {
        return withContext(Dispatchers.IO) {
            databaseDataSource.insertCliente(context, cliente)
        }
    }

    suspend fun getClientePorDNI(context: Context, dni: Int): Cliente {
        return withContext(Dispatchers.IO) {
            databaseDataSource.getAllTheClientes(context).first {
                it.dni == dni
            }
        }

    }
}
package com.example.android_ejercicios_xml.domain.repositories

import android.content.Context
import com.example.android_ejercicios_xml.data.datasources.DatabaseDataSource
import com.example.android_ejercicios_xml.domain.models.Cuenta
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CuentasRepository {
    private val databaseDataSource = DatabaseDataSource()

    suspend fun getAllTheClientes(context: Context): List<Cuenta> {
        return  withContext(Dispatchers.IO){
            databaseDataSource.getAllTheCuentas(context)
        }
    }
    suspend fun insertCuenta(context: Context,cuenta: Cuenta){
        return withContext(Dispatchers.IO){
            databaseDataSource.insertCuenta(context,cuenta)
        }
    }
}
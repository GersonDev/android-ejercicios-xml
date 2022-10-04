package com.example.android_ejercicios_xml.domain.repositories

import android.content.Context
import com.example.android_ejercicios_xml.data.datasources.DatabaseDataSource
import com.example.android_ejercicios_xml.domain.models.Movimiento
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MovimientosRepository {
    private val databaseDataSource = DatabaseDataSource()

    suspend fun getAllTheMovimientos(context: Context): List<Movimiento> {
        return withContext(Dispatchers.IO) {
            databaseDataSource.getAllMovimientos(context)
        }
    }

    suspend fun insertMovimiento(context: Context, movimiento: Movimiento) {
        return withContext(Dispatchers.IO) {
            databaseDataSource.insertMovimieto(context, movimiento)
        }
    }
}
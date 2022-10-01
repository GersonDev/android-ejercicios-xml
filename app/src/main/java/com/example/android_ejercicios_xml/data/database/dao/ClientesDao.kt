package com.example.android_ejercicios_xml.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.android_ejercicios_xml.data.database.entities.ClienteEntity

@Dao
interface ClientesDao {

    @Query("SELECT * FROM clientes")
    suspend fun getClientes(): List<ClienteEntity>

    @Insert
    suspend fun insertCliente(clienteEntity: ClienteEntity)
}
package com.example.android_ejercicios_xml.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "clientes")
data class ClienteEntity(
    @PrimaryKey(autoGenerate = true) var id: Int = 0,
    @ColumnInfo(name = "dni") var dni: Int,
    @ColumnInfo(name = "nombreDelCliente") var nombreCliente: String,
    @ColumnInfo(name = "direccion") var direccion: String,
    @ColumnInfo(name = "distrito") var distrito: String

)

package com.example.android_ejercicios_xml.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movimientos")
data class MovimientoEntity(
    @PrimaryKey(autoGenerate = true) var id:Int = 0,
    @ColumnInfo(name = "numeroDeCuenta") var numeroDeCuenta: Int,
    @ColumnInfo(name = "fechaOperacion") var fechaOperacion: String,
    @ColumnInfo(name = "descripcion") var descripcion: String,
    @ColumnInfo(name = "numeroDeOperacion") var numeroDeOperacion: Int,
    @ColumnInfo(name = "tipoDeOperacion") var tipoDeOperacion: String,
    @ColumnInfo(name = "importe") var importe: Double,
    @ColumnInfo(name = "saldoContable") var saldoContable: Double,

    )
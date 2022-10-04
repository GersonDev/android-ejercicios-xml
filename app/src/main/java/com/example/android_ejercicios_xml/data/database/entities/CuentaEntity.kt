package com.example.android_ejercicios_xml.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cuentas")
data class CuentaEntity (
    @PrimaryKey(autoGenerate = true) var id: Int = 0,
    @ColumnInfo(name = "numeroDeCuenta") var numeroDeCuenta: Int,
    @ColumnInfo(name = "tipoDeCuenta") var tipoDeCuenta: String,
    @ColumnInfo(name = "moneda") var moneda: String,
    @ColumnInfo(name = "saldoActual") var saldoActual: Double,
    @ColumnInfo(name = "dni") var dni: Int
        )

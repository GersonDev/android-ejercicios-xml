package com.example.android_ejercicios_xml.domain.models

data class Movimiento(
    val numeroDeCuenta: Int,
    val fechaOperacion: String,
    val descripcion: String,
    val numeroDeOperacion: Int,
    val tipoDeOperacion: String,
    val importe: Double,
    val saldoContable: Double
)

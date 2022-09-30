package com.example.android_ejercicios_xml.domain.models

data class Movimientos(
    val numeroDeCuenta:Int,
    val fechaOperacion:String,
    val descripcion:String,
    val numeroDeOperacion:Int,
    val tipoDeOperacion:Int,
    val importe:Double,
    val saldoContable:Double
)

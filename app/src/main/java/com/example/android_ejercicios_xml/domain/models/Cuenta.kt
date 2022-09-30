package com.example.android_ejercicios_xml.domain.models

data class Cuenta (
    val numeroDeCuenta:Int,
    val tipoDeCuenta:Int,
    val moneda:String,
    val saldoActual:Double,
    val dni:Int
        )
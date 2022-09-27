package com.example.android_ejercicios_xml.domain.models

data class Cronograma(
    val vencimiento: String,
    val amortizacion: Float,
    val interes: Double,
    val seguros: Double,
    val subvencion: Double,
    val cuota: Double,
    val saldo: Double
)

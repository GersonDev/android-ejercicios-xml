package com.example.android_ejercicios_xml.domain.models

data class cronograma(
    val vencimiento: String,
    val amortizacion: Double,
    val interes: Double,
    val seguros: Double,
    val subvencion: Double,
    val cuota: Double,
    val saldo: Double
)

package com.istea.appdelclima.repository

data class Clima (
    val temperatura: Int,
    val humedad: Float,
    val ciudad: String,
    val st: Int,
    val viento: Int,
    val latitud: Long,
    val longitud: Long,
    val estado: String
)
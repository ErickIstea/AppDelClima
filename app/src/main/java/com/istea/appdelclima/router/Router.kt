package com.istea.appdelclima.router

interface Router {
    fun navegar(ruta: Ruta )
}

sealed class Ruta(val id: String) {
    data object Ciudades: Ruta("ciudades")
    data class Clima(val lat:Double=0.0,val lon: Double=0.0): Ruta("clima")
}
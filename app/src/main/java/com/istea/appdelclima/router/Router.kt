package com.istea.appdelclima.router

interface Router {
    fun navegar(ruta: Ruta )
}

sealed class Ruta(val id: String) {
    data object Ciudades: Ruta("ciudades")
    data class Clima(val lat: Float,val lon:Float, val nombre:String): Ruta("clima")
}

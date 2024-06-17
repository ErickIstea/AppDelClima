package com.istea.appdelclima.router

import com.istea.appdelclima.repository.modelos.Ciudad

interface Router {
    fun navegar(ruta: Ruta )
}

sealed class Ruta(val id: String) {
    data object Ciudades: Ruta("ciudades")
    data class Clima(val lat: Float,val lon:Float): Ruta("clima")
}
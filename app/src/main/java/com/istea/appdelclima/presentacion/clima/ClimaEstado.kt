package com.istea.appdelclima.presentacion.clima

sealed class ClimaEstado {
    data class Exitoso (
        val ciudad: String = "",
        val temperatura: Int = 0,
        val descripcion: String= "",
        val st :Int = 0,
    ) : ClimaEstado()
    data class Error(
        val mensaje :String = "",
    ) : ClimaEstado()
    data object Vacio: ClimaEstado()
    data object Cargando: ClimaEstado()

}

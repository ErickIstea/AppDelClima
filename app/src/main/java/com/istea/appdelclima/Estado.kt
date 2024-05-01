package com.istea.appdelclima

sealed class Estado {
    data class Exitoso (
        val ciudad: String = "",
        val temperatura: Int = 0,
        val descripcion: String= "",
        val st :Int = 0,
    ) : Estado()
    data class Error(
        val mensaje :String = "",
    ) : Estado ()
    data object Vacio: Estado()
}

package com.istea.appdelclima.repository

import com.istea.appdelclima.repository.modelos.Ciudad
import com.istea.appdelclima.repository.modelos.Clima2

class RepositorioMock  : Repositorio {
    override suspend fun buscarCiudad(ciudad: String): List<Ciudad> {
        val ciudad1 = Ciudad(name = "jojo",
            lat = -23.0,
            lon = -24.3,
            state = "Argentina")
        val ciudad2 =Ciudad(name = "jojo",
            lat = -23.0,
            lon = -24.3,
            state = "Argentina")
        val ciudad3 =Ciudad(name = "jojo",
            lat = -23.0,
            lon = -24.3,
            state = "Argentina")
        return listOf(ciudad1,ciudad2,ciudad3)
    }

    override suspend fun traerClima(ciudad: Ciudad): Clima2 {
        TODO("Not yet implemented")
    }

    override suspend fun traerPronostico(ciudad: Ciudad): List<Clima2> {
        TODO("Not yet implemented")
    }
}
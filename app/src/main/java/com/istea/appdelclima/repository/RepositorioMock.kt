package com.istea.appdelclima.repository

import com.istea.appdelclima.repository.modelos.Ciudad
import com.istea.appdelclima.repository.modelos.Clima

class RepositorioMock  : Repositorio {
    override suspend fun buscarCiudad(ciudad: String): List<Ciudad> {
        val ciudad1 = Ciudad(name = "Cordoba",
            lat = -23.0f,
            lon = -24.3f,
            country = "Argentina")
        val ciudad2 =Ciudad(name = "Buenos Aires",
            lat = -23.0f,
            lon = -24.3f,
            country = "Argentina")
        val ciudad3 =Ciudad(name = "La Plata",
            lat = -23.0f,
            lon = -24.3f,
            country = "Argentina")
        return listOf(ciudad1,ciudad2,ciudad3)
    }

    override suspend fun traerClima(lat: Float, lon: Float): Clima {
        TODO("Not yet implemented")
    }

    override suspend fun traerPronostico(lat: Float, lon: Float): List<Clima> {
        TODO("Not yet implemented")
    }
}
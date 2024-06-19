package com.istea.appdelclima.repository

import com.istea.appdelclima.repository.modelos.Ciudad
import com.istea.appdelclima.repository.modelos.Clima
import com.istea.appdelclima.repository.modelos.ListForecast

class RepositorioMock  : Repositorio {

    val cordoba = Ciudad(name = "Cordoba",
        lat = -23.0f,
        lon = -24.3f,
        country = "Argentina")
    val bsAs = Ciudad(name = "Buenos Aires",
        lat = -23.0f,
        lon = -24.3f,
        country = "Argentina")
    val laPlata = Ciudad(name = "La Plata",
        lat = -23.0f,
        lon = -24.3f,
        country = "Argentina")

    val ciudades = listOf(cordoba,bsAs,laPlata)

    override suspend fun buscarCiudad(ciudad: String): List<Ciudad> {
        if (ciudad == "error"){
            throw Exception()
        }
        return ciudades.filter { it.name.contains(ciudad,ignoreCase = true) }
    }

    override suspend fun traerClima(lat: Float, lon: Float): Clima {
        TODO("Not yet implemented")
    }

    override suspend fun traerPronostico(nombre: String): List<ListForecast> {
        TODO("Not yet implemented")
    }
}


class RepositorioMockError  : Repositorio {

    override suspend fun buscarCiudad(ciudad: String): List<Ciudad> {
        throw Exception()
    }

    override suspend fun traerClima(lat: Float, lon: Float): Clima {
        throw Exception()
    }

    override suspend fun traerPronostico(nombre: String): List<ListForecast> {
        throw Exception()
    }
}
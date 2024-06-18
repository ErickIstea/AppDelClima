package com.istea.appdelclima.repository

import com.istea.appdelclima.repository.modelos.Ciudad
import com.istea.appdelclima.repository.modelos.Clima
import com.istea.appdelclima.repository.modelos.ListForecast

interface Repositorio {
    suspend fun buscarCiudad(ciudad: String): List<Ciudad>
    suspend fun traerClima(lat: Float, lon: Float) : Clima
    suspend fun traerPronostico(nombre: String) : List<ListForecast>
}
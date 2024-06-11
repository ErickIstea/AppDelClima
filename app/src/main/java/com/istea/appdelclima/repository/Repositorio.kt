package com.istea.appdelclima.repository

import com.istea.appdelclima.repository.modelos.Ciudad
import com.istea.appdelclima.repository.modelos.Clima2

interface Repositorio {
    suspend fun buscarCiudad(ciudad: String): Array<Ciudad>
    suspend fun traerClima(ciudad: Ciudad) : Clima2
    suspend fun traerPronostico(ciudad: Ciudad) : List<Clima2>
}
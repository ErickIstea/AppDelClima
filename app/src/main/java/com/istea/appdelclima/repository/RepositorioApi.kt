package com.istea.appdelclima.repository

import com.istea.appdelclima.repository.modelos.Ciudad
import com.istea.appdelclima.repository.modelos.Clima
import com.istea.appdelclima.repository.modelos.Clima2
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.http.HttpStatusCode
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

class RepositorioApi : Repositorio {

    private val apiKey = "95e93e4f7a36fc511148468d1774792d"
    private val cliente = HttpClient(){
        install(ContentNegotiation){
            json(Json {
                ignoreUnknownKeys = true
            })
        }
    }

    override suspend fun buscarCiudad(ciudad: String): List<Ciudad> {
        val respuesta = cliente.get("http://api.openweathermap.org/geo/1.0/direct"){
            parameter("q",ciudad)
            parameter("limit",5)
            parameter("appid",apiKey)
        }
        if (respuesta.status == HttpStatusCode.OK){
            val ciudades = respuesta.body<List<Ciudad>>()
            return ciudades
        }else{
            throw Exception()
        }
    }

    override suspend fun traerClima(ciudad: Ciudad): Clima2 {
        val respuesta = cliente.get("https://api.openweathermap.org/data/2.5/weather"){
            parameter("lat",ciudad.lat)
            parameter("lon",ciudad.lon)
            parameter("units","metric")
            parameter("appid",apiKey)
        }
        if (respuesta.status == HttpStatusCode.OK){
            val clima = respuesta.body<Clima2>()
            return clima
        }else{
            throw Exception()
        }
    }

    override suspend fun traerPronostico(ciudad: Ciudad): List<Clima2> {
        TODO("Not yet implemented")
    }
}
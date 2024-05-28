package com.istea.appdelclima.presentacion.clima

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.istea.appdelclima.repository.Clima

class ClimaViewModel : ViewModel() {

    var uiState by mutableStateOf<ClimaEstado>(ClimaEstado.Vacio)

    fun ejecutar(intencion: ClimaIntencion){
        when(intencion){
            ClimaIntencion.BorrarTodo -> borrarTodo()
            ClimaIntencion.MostrarCaba -> mostrarCaba()
            ClimaIntencion.MostrarCordoba -> mostrarCordoba()
            ClimaIntencion.MostrarError -> mostrarError()
        }
    }

    private fun mostrarError(){
        uiState = ClimaEstado.Error("este es un error de mentiras")
    }

    private fun borrarTodo(){
        uiState = ClimaEstado.Vacio
    }

    private fun mostrarCaba(){
        uiState = ClimaEstado.Exitoso(
            ciudad= climaCABA.ciudad,
            temperatura = climaCABA.temperatura,
            descripcion = climaCABA.estado,
            st = climaCABA.st
        )
    }

    private fun mostrarCordoba(){
        uiState = ClimaEstado.Exitoso(
            ciudad= climaCordoba.ciudad,
            temperatura = climaCordoba.temperatura,
            descripcion = climaCordoba.estado,
            st = climaCordoba.st
        )
    }

    private val climaCordoba = Clima(
        ciudad = "Cordoba",
        temperatura = 14,
        estado = "nublado",
        humedad = 18.0F,
        st= 10,
        viento = 30,
        latitud = 12323123,
        longitud = 1143234
    )

    private val climaCABA = Clima(
        ciudad = "CABA",
        temperatura = 20,
        estado = "Soleado",
        humedad = 18.0F,
        st= 30,
        viento = 30,
        latitud = 12323123,
        longitud = 1143234
    )
}
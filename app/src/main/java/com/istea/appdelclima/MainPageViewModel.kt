package com.istea.appdelclima

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class MainPageViewModel : ViewModel() {

    var uiState by mutableStateOf<Estado>(Estado.Vacio)

    fun ejecutarIntencion(intencion: Intencion){
        when(intencion){
            Intencion.BorrarTodo -> borrarTodo()
            Intencion.MostrarCaba -> mostrarCaba()
            Intencion.MostrarCordoba -> mostrarCordoba()
            Intencion.MostrarError -> mostrarError()
        }
    }

    private fun mostrarError(){
        uiState = Estado.Error("este es un error de mentiras")
    }

    private fun borrarTodo(){
        uiState = Estado.Vacio
    }

    private fun mostrarCaba(){
        uiState = Estado.Exitoso(
            ciudad= climaCABA.ciudad,
            temperatura = climaCABA.temperatura,
            descripcion = climaCABA.estado,
            st = climaCABA.st
        )
    }

    private fun mostrarCordoba(){
        uiState = Estado.Exitoso(
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
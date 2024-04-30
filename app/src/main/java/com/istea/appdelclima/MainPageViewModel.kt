package com.istea.appdelclima

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class MainPageViewModel : ViewModel() {
    val ciudad = mutableStateOf<String>("")
    val temperatura = mutableStateOf<Int>(0)
    val descripcion = mutableStateOf<String>("")
    val st = mutableStateOf<Int>(0)
    val noHayDatos = mutableStateOf(true)

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

    fun borrarTodo(){
        ciudad.value = ""
        temperatura.value = 0
        descripcion.value = ""
        st.value = 0
        noHayDatos.value = true
    }

    fun mostrarCaba(){
        ciudad.value = climaCABA.ciudad
        temperatura.value = climaCABA.temperatura
        descripcion.value = climaCABA.estado
        st.value = climaCABA.st
        noHayDatos.value = false
    }

    fun mostrarCordoba(){
        ciudad.value = climaCordoba.ciudad
        temperatura.value = climaCordoba.temperatura
        descripcion.value = climaCordoba.estado
        st.value = climaCordoba.st
        noHayDatos.value = false
    }

}
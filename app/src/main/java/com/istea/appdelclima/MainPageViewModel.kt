package com.istea.appdelclima

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class MainPageViewModel : ViewModel() {
    val ciudad = mutableStateOf<String>("")
    val temperatura = mutableStateOf<Int>(0)
    val descripcion = mutableStateOf<String>("")
    val st = mutableStateOf<Int>(0)

    fun borrarTodo(){
        ciudad.value = ""
        temperatura.value = 0
        descripcion.value = ""
        st.value = 0
    }

    fun mostrarCaba(){
        ciudad.value = "CABA"
        temperatura.value = 10
        descripcion.value = "nublado"
        st.value = 9
    }

    fun mostrarCordoba(){
        ciudad.value = "Cordoba"
        temperatura.value = 20
        descripcion.value = "soleado"
        st.value = 23
    }
}
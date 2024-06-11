package com.istea.appdelclima.presentacion.ciudades

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.istea.appdelclima.repository.Repositorio
import kotlinx.coroutines.launch

class CiudadesViewModel(
    val repositorio: Repositorio
) : ViewModel(){

    var uiState by mutableStateOf<CiudadesEstado>(CiudadesEstado.Vacio)

    fun ejecutar(intencion: CiudadesIntencion){
        when(intencion){
            is CiudadesIntencion.Buscar -> buscar(nombre = intencion.nombre)
            is CiudadesIntencion.Seleccionar -> seleccionar(indice = intencion.indice)
        }
    }

    private fun buscar( nombre: String){

        uiState = CiudadesEstado.Cargando
        viewModelScope.launch {
            try {
                val listaDeCiudades = repositorio.buscarCiudad(nombre)
                uiState = CiudadesEstado.Resultado(listaDeCiudades)
            } catch (exeption: Exception){
                uiState = CiudadesEstado.Error("Error al buscar la ciudad")
            }
        }
    }

    private fun seleccionar(indice: Int){
        uiState = CiudadesEstado.Vacio
    }
}


class CiudadesViewModelFactory(
    private val repositorio: Repositorio
) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CiudadesViewModel::class.java)) {
            return CiudadesViewModel(repositorio) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
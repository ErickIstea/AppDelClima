package com.istea.appdelclima.presentacion.clima

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.istea.appdelclima.presentacion.ciudades.CiudadesViewModel
import com.istea.appdelclima.repository.Repositorio
import com.istea.appdelclima.repository.RepositorioApi
import com.istea.appdelclima.repository.RepositorioMock
import com.istea.appdelclima.repository.modelos.Ciudad
import com.istea.appdelclima.repository.modelos.Clima
import com.istea.appdelclima.router.Router
import kotlinx.coroutines.launch

class ClimaViewModel(
    val respositorio: Repositorio,
    val router: Router,
    val lat : Float,
    val lon : Float
) : ViewModel() {

    var uiState by mutableStateOf<ClimaEstado>(ClimaEstado.Vacio)

    fun ejecutar(intencion: ClimaIntencion){
        when(intencion){
            ClimaIntencion.actualizarClima -> traerClima()
        }
    }

    fun traerClima() {
        uiState = ClimaEstado.Cargando
        viewModelScope.launch {
            try{
                val clima = respositorio.traerClima(lat = lat, lon = lon)
                uiState = ClimaEstado.Exitoso(
                    ciudad = clima.name ,
                    temperatura = clima.main.temp,
                    descripcion = clima.weather.first().description,
                    st = clima.main.feels_like,
                )
            } catch (exception: Exception){
                uiState = ClimaEstado.Error(exception.localizedMessage ?: "error desconocido")
            }
        }
    }

}

class ClimaViewModelFactory(
    private val repositorio: Repositorio,
    private val router: Router,
    private val lat: Float,
    private val lon: Float,
) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ClimaViewModel::class.java)) {
            return ClimaViewModel(repositorio,router,lat,lon) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
package com.istea.appdelclima.presentacion.clima

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.istea.appdelclima.presentacion.clima.actual.ClimaView
import com.istea.appdelclima.presentacion.clima.actual.ClimaViewModel
import com.istea.appdelclima.presentacion.clima.actual.ClimaViewModelFactory
import com.istea.appdelclima.presentacion.clima.pronostico.PronosticoView
import com.istea.appdelclima.presentacion.clima.pronostico.PronosticoViewModel
import com.istea.appdelclima.presentacion.clima.pronostico.PronosticoViewModelFactory
import com.istea.appdelclima.repository.RepositorioApi
import com.istea.appdelclima.router.Enrutador

@Composable
fun ClimaPage(
    navHostController: NavHostController,
    lat : Float,
    lon : Float,
    nombre: String
){
    val viewModel : ClimaViewModel = viewModel(
        factory = ClimaViewModelFactory(
            repositorio = RepositorioApi(),
            router = Enrutador(navHostController),
            lat = lat,
            lon = lon,
            nombre = nombre
        )
    )
    val pronosticoViewModel : PronosticoViewModel = viewModel(
        factory = PronosticoViewModelFactory(
            repositorio = RepositorioApi(),
            router = Enrutador(navHostController),
            nombre = nombre
        )
    )

    Column {
        ClimaView(
            state = viewModel.uiState,
            onAction = { intencion ->
                viewModel.ejecutar(intencion)
            }
        )
        PronosticoView(
            state = pronosticoViewModel.uiState,
            onAction = { intencion ->
                pronosticoViewModel.ejecutar(intencion)
            }
        )
    }

}

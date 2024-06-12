package com.istea.appdelclima.presentacion.clima

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.istea.appdelclima.presentacion.ciudades.CiudadesViewModel
import com.istea.appdelclima.presentacion.ciudades.CiudadesViewModelFactory
import com.istea.appdelclima.repository.RepositorioApi
import com.istea.appdelclima.repository.RepositorioMock
import com.istea.appdelclima.router.Enrutador
import com.istea.appdelclima.router.Router

@Composable
fun ClimaPage(
    navHostController: NavHostController
){
    val viewModel : ClimaViewModel = viewModel(
        factory = ClimaViewModelFactory(
            repositorio = RepositorioApi(),
            router = Enrutador(navHostController)
        )
    )
    ClimaView(
        state = viewModel.uiState,
        onAction = { intencion ->
            viewModel.ejecutar(intencion)
        }
    )
}

package com.istea.appdelclima.presentacion.clima

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.istea.appdelclima.repository.RepositorioMock

@Composable
fun MainPage(){
    val viewModel : ClimaViewModel = viewModel(factory = ClimaViewModel.factory)
    ClimaView(
        state = viewModel.uiState,
        onAction = { intencion ->
            viewModel.ejecutar(intencion)
        }
    )
}

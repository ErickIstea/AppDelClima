package com.istea.appdelclima

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.istea.appdelclima.ui.theme.AppDelClimaTheme

@Composable
fun MainPage(){
    MainView(viewModel = viewModel())
}

@Composable
fun MainView(
    modifier: Modifier = Modifier,
    viewModel :MainPageViewModel
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (viewModel.noHayDatos.value) {
            Text(text = "No hay nada que mostrar")
        } else {
            Text(text = viewModel.ciudad.value, style = MaterialTheme.typography.titleMedium)
            Text(text = "${viewModel.temperatura.value}°", style = MaterialTheme.typography.titleLarge)
            Text(text = viewModel.descripcion.value, style = MaterialTheme.typography.bodyMedium)
            Text(text = "sensacionTermica: ${viewModel.st.value}°", style = MaterialTheme.typography.bodyMedium)
        }

        Spacer(modifier = Modifier.height(100.dp))

        Button(onClick = { viewModel.borrarTodo() }) {
            Text(text = "Borrar todo")
        }
        Button(onClick = { viewModel.mostrarCaba() }) {
            Text(text = "Mostrar Caba")
        }
        Button(onClick = { viewModel.mostrarCordoba() }) {
            Text(text = "Mostrar Cordoba")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainPagePreview() {
    AppDelClimaTheme {
        MainView(viewModel=viewModel())
    }
}
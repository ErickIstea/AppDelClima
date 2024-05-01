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
    val viewModel : MainPageViewModel = viewModel()
    MainView(
        state = viewModel.uiState,
        onAction = { intencion ->
            viewModel.ejecutarIntencion(intencion)
        }
    )
}

@Composable
fun MainView(
    modifier: Modifier = Modifier,
    state : Estado,
    onAction: (Intencion)->Unit
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        when(state){
            is Estado.Error -> ErrorView(mensaje = state.mensaje)
            is Estado.Exitoso -> ClimaView(ciudad = state.ciudad, temperatura = state.temperatura, descripcion = state.descripcion, st = state.st)
            Estado.Vacio -> EmptyView()
        }

        Spacer(modifier = Modifier.height(100.dp))

        Button(onClick = { onAction(Intencion.BorrarTodo) }) {
            Text(text = "Borrar todo")
        }
        Button(onClick = { onAction(Intencion.MostrarCaba) }) {
            Text(text = "Mostrar Caba")
        }
        Button(onClick = { onAction(Intencion.MostrarCordoba) }) {
            Text(text = "Mostrar Cordoba")
        }
        Button(onClick = { onAction(Intencion.MostrarError) }) {
            Text(text = "Mostrar Error")
        }
    }
}

@Composable
fun EmptyView(){
    Text(text = "No hay nada que mostrar")
}

@Composable
fun ErrorView(mensaje: String){
    Text(text = mensaje)
}

@Composable
fun ClimaView(ciudad: String, temperatura: Int, descripcion: String, st:Int){
    Column {
        Text(text = ciudad, style = MaterialTheme.typography.titleMedium)
        Text(text = "${temperatura}°", style = MaterialTheme.typography.titleLarge)
        Text(text = descripcion, style = MaterialTheme.typography.bodyMedium)
        Text(text = "sensacionTermica: ${st}°", style = MaterialTheme.typography.bodyMedium)
    }
}

@Preview(showBackground = true)
@Composable
fun MainPagePreview() {
    AppDelClimaTheme {
        MainView(state = Estado.Vacio, onAction = {})
    }
}

@Preview(showBackground = true)
@Composable
fun MainPagePreview2() {
    AppDelClimaTheme {
        MainView(state = Estado.Error("Se rompio todo"), onAction = {})
    }
}

@Preview(showBackground = true)
@Composable
fun MainPagePreview3() {
    AppDelClimaTheme {
        MainView(state = Estado.Exitoso(ciudad = "Mendoza", temperatura = 0), onAction = {})
    }
}
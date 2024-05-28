package com.istea.appdelclima.presentacion.clima

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
import com.istea.appdelclima.ui.theme.AppDelClimaTheme


@Composable
fun ClimaView(
    modifier: Modifier = Modifier,
    state : ClimaEstado,
    onAction: (ClimaIntencion)->Unit
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        when(state){
            is ClimaEstado.Error -> ErrorView(mensaje = state.mensaje)
            is ClimaEstado.Exitoso -> ClimaView(
                ciudad = state.ciudad,
                temperatura = state.temperatura,
                descripcion = state.descripcion,
                st = state.st
            )
            ClimaEstado.Vacio -> EmptyView()
            ClimaEstado.Cargando -> EmptyView()
        }

        Spacer(modifier = Modifier.height(100.dp))

        Button(onClick = { onAction(ClimaIntencion.BorrarTodo) }) {
            Text(text = "Borrar todo")
        }
        Button(onClick = { onAction(ClimaIntencion.MostrarCaba) }) {
            Text(text = "Mostrar Caba")
        }
        Button(onClick = { onAction(ClimaIntencion.MostrarCordoba) }) {
            Text(text = "Mostrar Cordoba")
        }
        Button(onClick = { onAction(ClimaIntencion.MostrarError) }) {
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
fun ClimaPreviewVacio() {
    AppDelClimaTheme {
        ClimaView(state = ClimaEstado.Vacio, onAction = {})
    }
}

@Preview(showBackground = true)
@Composable
fun ClimaPreviewError() {
    AppDelClimaTheme {
        ClimaView(state = ClimaEstado.Error("Se rompio todo"), onAction = {})
    }
}

@Preview(showBackground = true)
@Composable
fun ClimaPreviewExitoso() {
    AppDelClimaTheme {
        ClimaView(state = ClimaEstado.Exitoso(ciudad = "Mendoza", temperatura = 0), onAction = {})
    }
}
package com.istea.appdelclima

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.istea.appdelclima.presentacion.ciudades.CiudadesPage
import com.istea.appdelclima.presentacion.clima.ClimaPage
import com.istea.appdelclima.router.Enrutador
import com.istea.appdelclima.router.Ruta

@Composable
fun MainPage() {
    val navHostController = rememberNavController()
    NavHost(
        navController = navHostController,
        startDestination = Ruta.Ciudades.id
    ) {
        composable(
            route = Ruta.Ciudades.id
        ) {
            CiudadesPage(navHostController)
        }
        composable(
            route = "clima?lat={lat}&lon={lon}",
            arguments =  listOf(
                navArgument("lat") { type= NavType.FloatType },
                navArgument("lon") { type= NavType.FloatType }
            )
        ) {
            val lat = it.arguments?.getFloat("lat") ?: 0.0f
            val lon = it.arguments?.getFloat("lon") ?: 0.0f
            ClimaPage(navHostController, lat = lat, lon = lon)

        }
    }
}
package com.istea.appdelclima.router

import androidx.navigation.NavHostController

class Enrutador(
    val navHostController: NavHostController
): Router {

    override fun navegar(ruta: Ruta) {
        navHostController.navigate(ruta.id)
    }
}
package com.istea.appdelclima.router

class MockRouter: Router {
    override fun navegar(ruta: Ruta) {
        println("navegar a : ${ ruta.id }" )
    }
}
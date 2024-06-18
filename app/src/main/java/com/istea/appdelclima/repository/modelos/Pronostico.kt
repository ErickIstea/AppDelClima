package com.istea.appdelclima.repository.modelos

import kotlinx.serialization.Serializable

@Serializable
data class ForecastDTO (
    val cod: String,
    val message: Long,
    val cnt: Long,
    val list: List<ListForecast>,
//    val city: CityForecast,
)

@Serializable
data class ListForecast(
    val dt: Long,
    val main: MainForecast,
//    val weather: List<WeatherForecast>,
//    val clouds: CloudsForecast,
//    val wind: Windforecast,
//    val visibility: Long,
//    val pop: Double,
//    val sys: SysForecast,
//    val dt_txt: String,
//    val rain: Rain,
)

@Serializable
data class MainForecast(
    val temp: Double,
    val feels_like: Double,
    val temp_min: Double,
    val temp_max: Double,
    val pressure: Long,
    val sea_level: Long,
    val grnd_level: Long,
    val humidity: Long,
    val temp_kf: Double,
)
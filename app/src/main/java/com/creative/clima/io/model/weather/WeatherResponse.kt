package com.creative.clima.io.model.weather

class WeatherResponse(
    val cod: String?,
    val message : String?,
    val coord: Coordinates?,
    val sys: System?,
    val weather: ArrayList<Weather>?,
    val main: Main?,
    val wind: Wind?,
    val rain: Rain?,
    val clouds: Clouds?,
    val dt: String?,
    val id: String?,
    val name: String?
)

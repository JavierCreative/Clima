package com.creative.clima.io

import com.creative.clima.io.model.weather.WeatherResponse
import retrofit2.http.GET
import retrofit2.Call
import retrofit2.http.Query

interface WeatherAPIService
{
    @GET("weather")
    fun getWeather(@Query("q") name : String, @Query("appid") key : String, @Query("units") units : String) : Call<WeatherResponse>

}
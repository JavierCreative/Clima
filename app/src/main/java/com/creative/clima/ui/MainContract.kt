package com.creative.clima.ui

import com.creative.clima.io.model.weather.WeatherResponse

interface MainContract
{
    interface MainModelContract
    {
        fun getWheater(name: String)
    }

    interface MainViewContract
    {
        fun addNewItem(response: WeatherResponse?, visible: Boolean)
    }

    interface MainPresenterContract
    {
        fun getWeather(name: String?)
        fun setResponse(response: WeatherResponse?)
        fun onDestroy()
    }
}
package com.creative.clima.io.config

import java.util.concurrent.TimeUnit

class ApiConfiguration
{
    public companion object
    {
        val TIME_OUT = 60L
        val TIME_UNIT = TimeUnit.SECONDS
        val BASE_URL = "https://api.openweathermap.org/data/2.5/"
        val API_KEY = "31cacfc277d4ab56418705a1b322d4c5"
        val ACCESS_KEY = "53d63049914ef89b978f238c43b2cc7552ea338f9b635ad5eb60c634f2013d75"
        val SECRET_KEY = "67e8c109f5c6866db602fa04510f37a29bab392122ce7d9ee96ca22fd8503bc0"
    }
}
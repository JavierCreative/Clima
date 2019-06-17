package com.creative.clima.io.config

import com.creative.clima.BuildConfig
import com.creative.clima.io.WeatherAPIService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.reflect.KClass

class ApiManager
{
    companion object
    {
        private var weatherAPIService : WeatherAPIService? = null

        private val httpClient = OkHttpClient.Builder()
            .connectTimeout(ApiConfiguration.TIME_OUT, ApiConfiguration.TIME_UNIT)
            .readTimeout(ApiConfiguration.TIME_OUT, ApiConfiguration.TIME_UNIT)
            .writeTimeout(ApiConfiguration.TIME_OUT, ApiConfiguration.TIME_UNIT)
            .addInterceptor(getLogs())

        private fun getLogs() : HttpLoggingInterceptor
        {
            return if (BuildConfig.DEBUG)
                HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
            else
                HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.NONE)
        }

        fun createService() : WeatherAPIService?
        {
            if (weatherAPIService == null)
            {
                val retro = Retrofit.Builder()
                    .baseUrl(ApiConfiguration.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(httpClient.build())
                    .build()
                weatherAPIService = retro.create(WeatherAPIService::class.java)
            }
            return weatherAPIService
        }

    }

}
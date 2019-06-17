package com.creative.clima.ui

import android.util.Log
import com.creative.clima.io.config.ApiConfiguration
import com.creative.clima.io.config.ApiManager
import com.creative.clima.io.model.weather.WeatherResponse
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainModel (presenter: MainPresenter) : MainContract.MainModelContract
{
    private val mPresenter : MainPresenter? = presenter

    override fun getWheater(name: String)
    {
        val call = ApiManager.createService()?.getWeather(name, ApiConfiguration.API_KEY,"metric")
        call?.enqueue(object :  Callback<WeatherResponse>
        {
            override fun onFailure(call: Call<WeatherResponse>, t: Throwable)
            {
                Log.wtf("MODEL",t.message)
            }

            override fun onResponse(call: Call<WeatherResponse>, response: Response<WeatherResponse>)
            {
                if (response.isSuccessful)
                {
                    mPresenter?.setResponse(response.body())
                }
                else
                {
                    mPresenter?.setResponse(response.body())
                }
            }

        })

    }
}
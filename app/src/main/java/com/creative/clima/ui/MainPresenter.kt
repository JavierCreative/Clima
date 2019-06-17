package com.creative.clima.ui

import com.creative.clima.io.model.weather.WeatherResponse

class MainPresenter (view: MainContract.MainViewContract) : MainContract.MainPresenterContract
{
    var mView : MainContract.MainViewContract? = view
    var mModel : MainContract.MainModelContract? = MainModel(this)

    override fun getWeather(name: String?)
    {
        if (name != null)
        {
            mModel?.getWheater(name)
        }
    }

    override fun setResponse(response: WeatherResponse?)
    {
        if (response != null)
        {
            mView?.addNewItem(response,true)
        }
        else
        {
            mView?.addNewItem(null,false)
        }
    }

    override fun onDestroy()
    {
        this.mView = null
        this.mModel = null
    }
}
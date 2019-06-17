package com.creative.clima.ui

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import android.widget.Toast
import com.creative.clima.R
import com.creative.clima.io.model.weather.WeatherResponse
import com.google.android.material.card.MaterialCardView
import com.google.android.material.textfield.TextInputEditText
import com.google.gson.Gson

class MainActivity : AppCompatActivity(), MainContract.MainViewContract
{
    var mPresenter : MainPresenter? = null
    var mSearchBar : TextInputEditText? = null
    var mHumidity : TextView? = null
    var mMaxTemp: TextView? = null
    var mMinTemp : TextView? = null
    var mWindSpeed : TextView? = null
    var mCity : TextView? = null
    var mCardViewCity : MaterialCardView? = null
    var mContext : Context? = null

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mPresenter = MainPresenter(this)
        mContext = this
        initComponents()
        setListeners()
    }

    private fun setListeners()
    {
        mSearchBar?.setOnEditorActionListener{ view, actionId, event ->
            return@setOnEditorActionListener when (actionId) {
                EditorInfo.IME_ACTION_SEARCH -> {
                    mPresenter?.getWeather(mSearchBar?.text.toString() +",mx")
                    val imm = mContext?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                    imm.hideSoftInputFromWindow(view.windowToken, 0)
                    true
                }
                else -> false
            }
        }
    }

    private fun initComponents()
    {
        mSearchBar = findViewById(R.id.search_textinputedittext)
        mHumidity = findViewById(R.id.humidity_textview)
        mWindSpeed = findViewById(R.id.windSpeed_textview)
        mMinTemp = findViewById(R.id.minTemp_textview)
        mMaxTemp = findViewById(R.id.maxTemp_textview)
        mCity = findViewById(R.id.cityName_cardview)
        mCardViewCity = findViewById(R.id.city_carview)
    }

    override fun addNewItem(response: WeatherResponse?, visible: Boolean)
    {
        if (visible)
        {
            mHumidity?.text = response?.main?.humidity.toString() + "%"
            mMaxTemp?.text = response?.main?.temp_max.toString() + "º"
            mMinTemp?.text = response?.main?.temp_min.toString() + "º"
            mWindSpeed?.text = response?.wind?.speed.toString() + "m/s"
            mCity?.text = response?.name
            mCardViewCity?.visibility = View.VISIBLE
        }
        else
        {
            mCardViewCity?.visibility = View.GONE
            Toast.makeText(mContext,"City Not Found :(",Toast.LENGTH_SHORT).show()
        }
    }
}

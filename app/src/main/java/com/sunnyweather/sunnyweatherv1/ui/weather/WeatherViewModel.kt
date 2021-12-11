package com.sunnyweather.sunnyweatherv1.ui.weather

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.sunnyweather.sunnyweatherv1.logic.Repository
import com.sunnyweather.sunnyweatherv1.logic.model.Location

/**
 * Created by wuto on 2021-12-09.
 */
class WeatherViewModel:ViewModel() {
    private val locationLiveData = MutableLiveData<Location>()

    var locationLng = ""

    var locationLat = ""

    var placeName = ""

    val weatherLiveData = Transformations.switchMap(locationLiveData){location ->
        Repository.refreshWeather(location.lng, location.lat)
    }

    fun refreshWeather(lng:String, lat:String){
        locationLiveData.value = com.sunnyweather.sunnyweatherv1.logic.model.Location(lng,lat)
    }

}
package com.sunnyweather.sunnyweatherv1.logic.network

import com.sunnyweather.sunnyweatherv1.SunnyWeatherApplication
import com.sunnyweather.sunnyweatherv1.logic.model.DailyResponse
import com.sunnyweather.sunnyweatherv1.logic.model.RealtimeResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by wuto on 2021-12-09.
 */
interface WeatherService {

    @GET("v2.5/${SunnyWeatherApplication.TOKEN}/{lng},{lat}/realtime.json")
    fun getRealtimeWeather(@Path("lng") lng:String,@Path("lat") lat:String):
            Call<RealtimeResponse>

    @GET("v2.5/${SunnyWeatherApplication.TOKEN}/{lng},{lat}/daily.json")
    fun getDailyWeather(@Path("lng") lng: String,@Path("lat") lat: String):
            Call<DailyResponse>
}
package com.sunnyweather.sunnyweatherv1.logic.network

import com.sunnyweather.sunnyweatherv1.SunnyWeatherApplication
import com.sunnyweather.sunnyweatherv1.logic.model.PlaceResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by wuto on 2021-12-09.
 */
interface PlaceService {
    @GET("v2/place?token=${SunnyWeatherApplication.TOKEN}&lang=zh_CN")
    fun searchPlaces(@Query("query") query: String): Call<PlaceResponse>
}
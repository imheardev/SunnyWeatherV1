package com.sunnyweather.sunnyweatherv1.logic.model

import com.google.gson.annotations.SerializedName

/**
 * Created by wuto on 2021-12-09.
 */
data class RealtimeResponse (val status:String,val result: Result){

    data class Result(val realtime:Realtime)

    data class Realtime(val skycon:String,val temperature:Float,
    @SerializedName("air_quality") val airQuality:AirQuality)

    data class AirQuality(val aqi:AQI)

    data class AQI(val chn:Float)
}

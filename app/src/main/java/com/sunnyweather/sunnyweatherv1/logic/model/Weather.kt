package com.sunnyweather.sunnyweatherv1.logic.model

/**
 * Created by wuto on 2021-12-09.
 */
data class Weather(val realtime:RealtimeResponse.Realtime,val daily:DailyResponse.Daily)

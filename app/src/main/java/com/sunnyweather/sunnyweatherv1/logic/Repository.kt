package com.sunnyweather.sunnyweatherv1.logic

import androidx.lifecycle.liveData
import com.sunnyweather.sunnyweatherv1.logic.dao.PlaceDao
import com.sunnyweather.sunnyweatherv1.logic.model.Place
import com.sunnyweather.sunnyweatherv1.logic.model.Weather
import com.sunnyweather.sunnyweatherv1.logic.network.SunnyWeatherNetwork
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlin.Exception
import kotlin.coroutines.CoroutineContext

/**
 * Created by wuto on 2021-12-09.
 */
object Repository {
    fun searchPlaces(query:String) = fire(Dispatchers.IO){
        val placeResponse = SunnyWeatherNetwork.searchPlaces(query)
        if (placeResponse.status == "ok"){
            val places = placeResponse.places
            Result.success(places)
        }else{
            Result.failure(RuntimeException("response status is" +
                    "${placeResponse.status}"))
        }
    }

    fun savePlace(place:Place) = PlaceDao.savePlace(place)

    fun getSavedPlace() = PlaceDao.getSavedPlace()

    fun isPlaceSaved() = PlaceDao.isPlaceSaved()

    fun refreshWeather(lng:String, lat:String) = fire(Dispatchers.IO){
        coroutineScope {
            val deferredRealtime = async {
                SunnyWeatherNetwork.getRealtimeWeather(lng,lat)
            }
            val deferredDaily = async {
                SunnyWeatherNetwork.getDailyWeather(lng,lat)
            }
            val realtimeResponse = deferredRealtime.await()
            val dailyResponse = deferredDaily.await()
            if(realtimeResponse.status == "ok" && dailyResponse.status =="ok"){
                val weather = Weather(realtimeResponse.result.realtime,
                dailyResponse.result.daily)
                Result.success(weather)
            }else{
                Result.failure(
                    java.lang.RuntimeException(
                        "realtime response status is ${realtimeResponse.status}" +
                    "daily response status is ${dailyResponse.status}"
                    )
                )
            }
        }
    }

    private fun<T> fire(context:CoroutineContext,block:suspend () -> Result<T>) =
        liveData<Result<T>>(context) {
            val result = try{
                block()
            }catch (e:Exception){
                Result.failure<T>(e)
            }
            emit(result)
        }
}
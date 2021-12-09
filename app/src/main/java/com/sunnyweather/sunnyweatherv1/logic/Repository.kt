package com.sunnyweather.sunnyweatherv1.logic

import androidx.lifecycle.liveData
import com.sunnyweather.sunnyweatherv1.logic.model.Place
import com.sunnyweather.sunnyweatherv1.logic.network.SunnyWeatherNetwork
import kotlinx.coroutines.Dispatchers
import kotlin.Exception

/**
 * Created by wuto on 2021-12-09.
 */
object Repository {
    fun searchPlaces(query:String) = liveData(Dispatchers.IO){
        val result = try {
            val placeResponse = SunnyWeatherNetwork.searchPlaces(query)
            if (placeResponse.status == "ok"){
                val places = placeResponse.places
                Result.success(places)
            }else{
                Result.failure(RuntimeException("response status is" +
                        "${placeResponse.status}"))
            }
        }catch (e:Exception){
            Result.failure<List<Place>>(e)
        }
        emit(result)
    }
}
package com.sunnyweather.sunnyweatherv1.logic.model

import android.location.Location
import com.google.gson.annotations.SerializedName

/**
 * Created by wuto on 2021-12-09.
 */
data class PlaceResponse(val status:String,val places:List<Place>)

data class Place(val name:String,val location: Loaction,
                 @SerializedName("formatted_address") val address:String)

data class Loaction(val lng:String, val lat:String)
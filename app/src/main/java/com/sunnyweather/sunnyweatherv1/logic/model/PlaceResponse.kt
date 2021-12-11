package com.sunnyweather.sunnyweatherv1.logic.model

import com.google.gson.annotations.SerializedName

/**
 * Created by wuto on 2021-12-09.
 */
data class PlaceResponse(val status:String,val places:List<Place>)

data class Place(val name:String,val location: Location,
                 @SerializedName("formatted_address") val address:String)

data class Location(val lng:String, val lat:String)
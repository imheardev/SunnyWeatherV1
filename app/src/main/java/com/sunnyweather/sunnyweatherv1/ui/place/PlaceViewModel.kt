package com.sunnyweather.sunnyweatherv1.ui.place

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.sunnyweather.sunnyweatherv1.logic.Repository
import com.sunnyweather.sunnyweatherv1.logic.model.Place

/**
 * Created by wuto on 2021-12-09.
 */
class PlaceViewModel: ViewModel() {
    private val searchLiveData = MutableLiveData<String>()

    val placeList = ArrayList<Place>()

    val placeLiveData = Transformations.switchMap(searchLiveData){query ->
        Repository.searchPlaces(query)
    }

    fun searchPlaces(query:String){
        searchLiveData.value = query
    }
}
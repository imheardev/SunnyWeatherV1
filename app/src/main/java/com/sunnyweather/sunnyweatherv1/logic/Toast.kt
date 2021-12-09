package com.sunnyweather.sunnyweatherv1.logic

import android.content.Context
import android.widget.Toast
import com.sunnyweather.sunnyweatherv1.SunnyWeatherApplication

/**
 * Created by wuto on 2021-12-09.
 */
fun String.showToast(duration:Int=Toast.LENGTH_SHORT){
    Toast.makeText(SunnyWeatherApplication.context,this,duration).show()
}
fun Int.showToast(duration:Int=Toast.LENGTH_SHORT){
    Toast.makeText(SunnyWeatherApplication.context,this,duration).show()
}
package com.sunnyweather.sunnyweatherv1.ui.place

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.sunnyweather.sunnyweatherv1.databinding.PlaceItemBinding
import com.sunnyweather.sunnyweatherv1.logic.model.Place

/**
 * Created by wuto on 2021-12-09.
 */
class PlaceAdapter(private val fragment: Fragment,private val placeList:List<Place>):
RecyclerView.Adapter<PlaceAdapter.ViewHolder>(){

    inner class ViewHolder(binding: PlaceItemBinding):RecyclerView.ViewHolder(binding.root){
        val placeName:TextView = binding.placeNmae
        val placeAddress:TextView = binding.palceAddress
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = PlaceItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val place = placeList[position]
        holder.placeName.text = place.name
        holder.placeAddress.text = place.address
    }

    override fun getItemCount() = placeList.size

}
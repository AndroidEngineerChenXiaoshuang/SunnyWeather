package com.jam.sunnyweather.ui.place

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import com.jam.sunnyweather.logic.model.Place
import com.jam.sunnyweather.logic.network.Repository
import java.util.ArrayList

class PlaceViewModel : ViewModel() {
    val placeList = ArrayList<Place>()

    private val searchLiveData = MutableLiveData<String>()

    val placeLiveData = searchLiveData.switchMap {
        Repository.searchPlaces(it)
    }

    fun searchPlaces(query: String) {
        searchLiveData.value = query
    }

}
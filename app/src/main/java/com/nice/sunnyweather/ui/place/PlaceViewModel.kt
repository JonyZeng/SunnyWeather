package com.nice.sunnyweather.ui.place

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.nice.sunnyweather.logic.Repository
import com.nice.sunnyweather.logic.model.Place
import com.nice.sunnyweather.util.LogUtil

class PlaceViewModel : ViewModel() {
    private val searchLiveData = MutableLiveData<String>()
    private val TAG = "PlaceViewModel"
    val placeList = ArrayList<Place>()
    val placeLiveData = Transformations.switchMap(searchLiveData) { query ->
        Repository.searchPlaces(query)
    }

    fun searchPlaces(query: String) {
        LogUtil.d(TAG, query)
        searchLiveData.value = query
    }
}
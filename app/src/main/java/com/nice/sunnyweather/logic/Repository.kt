package com.nice.sunnyweather.logic

import androidx.lifecycle.liveData
import com.nice.sunnyweather.logic.model.Place
import com.nice.sunnyweather.logic.network.SunnyWeatherNetwork
import com.nice.sunnyweather.util.LogUtil
import kotlinx.coroutines.Dispatchers
import java.lang.RuntimeException

object Repository {
    private const val TAG = "Repository"
    fun searchPlaces(query: String) = liveData(Dispatchers.IO) {
        val result = try {
            val placeResponse = SunnyWeatherNetwork.searchPlaces(query)
            if (placeResponse.status == "ok") {
                LogUtil.d(TAG, "status=ok")
                val places = placeResponse.places
                Result.success(places)
            } else {
                Result.failure(RuntimeException("response status is ${placeResponse.status}"))
            }
        } catch (e: Exception) {
            Result.failure<List<Place>>(e)
        }
        emit(result)
    }
}
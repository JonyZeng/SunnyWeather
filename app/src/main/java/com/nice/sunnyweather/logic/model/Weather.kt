package com.nice.sunnyweather.logic.model

class Weather {
    data class Weather(val realtime: RealtimeResponse.Realtime, val daily: DailyResponse.Daily)
}
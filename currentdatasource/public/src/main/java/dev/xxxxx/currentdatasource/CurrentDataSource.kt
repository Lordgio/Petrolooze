package dev.xxxxx.currentdatasource

import dev.xxxxx.currentdatasource.data.SearchFeature
import dev.xxxxx.currentdatasource.data.Station

interface CurrentDataSource {

    suspend fun getStations(skipCaches: Boolean = false): List<Station>

    suspend fun getStations(feature: SearchFeature, skipCaches: Boolean = false): List<Station>
}
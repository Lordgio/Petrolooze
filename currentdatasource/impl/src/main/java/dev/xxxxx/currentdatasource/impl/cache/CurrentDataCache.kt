package dev.xxxxx.currentdatasource.impl.cache

import dev.xxxxx.currentdatasource.data.Station
import javax.inject.Singleton

@Singleton
class CurrentDataCache {

    private val map = mutableMapOf<String, List<Station>>()

    fun saveData(data: List<Station>, id: String) {
        if (data.isNotEmpty() && id.isNotBlank()) {
            map[id] = data
        }
    }

    fun getData(id: String): List<Station> {
        return map[id] ?: emptyList()
    }
}
package dev.xxxxx.masterdatasource.impl.cache

import dev.xxxxx.masterdatasource.data.Autonomy
import javax.inject.Singleton

@Singleton
class BaseDataCache {

    var autonomies: List<Autonomy> = listOf()
        private set

    fun <T> saveToCache(data: List<T>) {
        when {
            data.isNotEmpty() && data.first() is Autonomy -> autonomies = data as List<Autonomy>
        }
    }
}
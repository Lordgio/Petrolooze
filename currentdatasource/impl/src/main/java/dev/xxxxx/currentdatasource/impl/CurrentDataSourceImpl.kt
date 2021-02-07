package dev.xxxxx.currentdatasource.impl

import arrow.core.Either
import dev.xxxxx.api.CurrentDataApi
import dev.xxxxx.api.data.NetworkError
import dev.xxxxx.api.data.Station as ApiStation
import dev.xxxxx.currentdatasource.CurrentDataSource
import dev.xxxxx.currentdatasource.data.SearchFeature
import dev.xxxxx.currentdatasource.data.Station
import dev.xxxxx.currentdatasource.impl.cache.CurrentDataCache
import dev.xxxxx.currentdatasource.impl.data.toAutonomy
import dev.xxxxx.currentdatasource.impl.data.toCity
import dev.xxxxx.currentdatasource.impl.data.toProduct
import dev.xxxxx.currentdatasource.impl.data.toProvince
import dev.xxxxx.currentdatasource.impl.data.toStation
import dev.xxxxx.db.CurrentDataDb
import javax.inject.Inject

class CurrentDataSourceImpl @Inject constructor(private val api: CurrentDataApi,
                                                private val db: CurrentDataDb,
                                                private val cache: CurrentDataCache) : CurrentDataSource {

    override suspend fun getStations(skipCaches: Boolean): List<Station> {
        TODO("Not yet implemented")
    }

    override suspend fun getStations(feature: SearchFeature, skipCaches: Boolean): List<Station> {

        return if (!skipCaches) {
            cache.getData(feature.id)
        } else {
            val data = getFeatureStations(feature).fold(
                ifLeft = { emptyList() },
                ifRight = { data -> data.map { it.toStation() } }
            )
            cache.saveData(data, feature.id)
            data
        }
    }

    private suspend fun getFeatureStations(feature: SearchFeature): Either<NetworkError, List<ApiStation>> {
        return when(feature) {
            is SearchFeature.Autonomy -> api.getStationsByAutonomy(feature.toAutonomy())
            is SearchFeature.City -> api.getStationsByCity(feature.toCity())
            is SearchFeature.Province -> api.getStationsByProvince(feature.toProvince())
            is SearchFeature.Product -> api.getStationsByProduct(feature.toProduct())
        }
    }
}
package dev.xxxxx.api.impl

import dev.xxxxx.api.CurrentDataApi
import dev.xxxxx.api.data.Autonomy
import dev.xxxxx.api.data.City
import dev.xxxxx.api.data.Product
import dev.xxxxx.api.data.Province
import dev.xxxxx.api.data.Station
import dev.xxxxx.api.impl.data.toStation
import dev.xxxxx.api.impl.retrofit.CurrentDataClient

class CurrentDataApiImpl(private val retrofitClient: CurrentDataClient) : CurrentDataApi {

    override suspend fun getAllStations(): List<Station> =
        retrofitClient
            .getStations()
            .stationList
            .map { it.toStation() }

    override suspend fun getStationsByAutonomy(autonomy: Autonomy): List<Station> =
        retrofitClient
            .getStationsByAutonomy(autonomy.id)
            .stationList
            .map { it.toStation() }

    override suspend fun getStationsByAutonomyAndProduct(autonomy: Autonomy, product: Product): List<Station> =
        retrofitClient
            .getStationsByAutonomyAndProduct(autonomy.id, product.id)
            .stationList
            .map { it.toStation() }

    override suspend fun getStationsByCity(city: City): List<Station> =
        retrofitClient
            .getStationsByCity(city.id)
            .stationList
            .map { it.toStation() }

    override suspend fun getStationsByCityAndProduct(city: City, product: Product): List<Station> =
        retrofitClient
            .getStationsByCityAndProduct(city.id, product.id)
            .stationList
            .map { it.toStation() }

    override suspend fun getStationsByProduct(product: Product): List<Station> =
        retrofitClient
            .getStationsByProduct(product.id)
            .stationList
            .map { it.toStation() }

    override suspend fun getStationsByProvince(province: Province): List<Station> =
        retrofitClient
            .getStationsByProvince(province.provinceId)
            .stationList
            .map { it.toStation() }

    override suspend fun getStationsByProvinceAndProduct(province: Province, product: Product): List<Station> =
        retrofitClient
            .getStationsByProvinceAndProduct(province.provinceId, product.id)
            .stationList
            .map { it.toStation() }
}

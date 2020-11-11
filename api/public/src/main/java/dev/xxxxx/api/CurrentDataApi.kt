package dev.xxxxx.api

import dev.xxxxx.api.data.Autonomy
import dev.xxxxx.api.data.City
import dev.xxxxx.api.data.Product
import dev.xxxxx.api.data.Province
import dev.xxxxx.api.data.Station


interface CurrentDataApi {

    suspend fun getAllStations(): List<Station>

    suspend fun getStationsByAutonomy(autonomy: Autonomy): List<Station>

    suspend fun getStationsByAutonomyAndProduct(autonomy: Autonomy, product: Product): List<Station>

    suspend fun getStationsByCity(city: City): List<Station>

    suspend fun getStationsByCityAndProduct(city: City, product: Product): List<Station>

    suspend fun getStationsByProduct(product: Product): List<Station>

    suspend fun getStationsByProvince(province: Province): List<Station>

    suspend fun getStationsByProvinceAndProduct(province: Province, product: Product): List<Station>
}

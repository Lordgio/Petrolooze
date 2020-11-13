package dev.xxxxx.api

import dev.xxxxx.api.data.Autonomy
import dev.xxxxx.api.data.City
import dev.xxxxx.api.data.Product
import dev.xxxxx.api.data.Province
import dev.xxxxx.api.data.Station


public interface CurrentDataApi {

    public suspend fun getAllStations(): List<Station>

    public suspend fun getStationsByAutonomy(autonomy: Autonomy): List<Station>

    public suspend fun getStationsByAutonomyAndProduct(autonomy: Autonomy, product: Product): List<Station>

    public suspend fun getStationsByCity(city: City): List<Station>

    public suspend fun getStationsByCityAndProduct(city: City, product: Product): List<Station>

    public suspend fun getStationsByProduct(product: Product): List<Station>

    public suspend fun getStationsByProvince(province: Province): List<Station>

    public suspend fun getStationsByProvinceAndProduct(province: Province, product: Product): List<Station>
}

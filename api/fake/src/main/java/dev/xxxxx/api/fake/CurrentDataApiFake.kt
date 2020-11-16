package dev.xxxxx.api.fake

import dev.xxxxx.api.CurrentDataApi
import dev.xxxxx.api.data.*
import dev.xxxxx.api.fake.mocks.StationMocks

class CurrentDataApiFake : CurrentDataApi {

    override suspend fun getAllStations(): List<Station> = getMockStations()

    override suspend fun getStationsByAutonomy(autonomy: Autonomy): List<Station> = getMockStations()

    override suspend fun getStationsByAutonomyAndProduct(autonomy: Autonomy,
                                                         product: Product): List<Station> = getMockStations()

    override suspend fun getStationsByCity(city: City): List<Station> = getMockStations()

    override suspend fun getStationsByCityAndProduct(city: City, product: Product): List<Station> = getMockStations()

    override suspend fun getStationsByProduct(product: Product): List<Station> = getMockStations()

    override suspend fun getStationsByProvince(province: Province): List<Station> = getMockStations()

    override suspend fun getStationsByProvinceAndProduct(province: Province,
                                                         product: Product): List<Station> = getMockStations()

    private fun getMockStations() = listOf<Station>(
        StationMocks.station1,
        StationMocks.station2,
        StationMocks.station3
    )
}
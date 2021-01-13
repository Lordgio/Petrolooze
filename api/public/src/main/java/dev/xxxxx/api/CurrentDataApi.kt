package dev.xxxxx.api

import arrow.core.Either
import dev.xxxxx.api.data.Autonomy
import dev.xxxxx.api.data.City
import dev.xxxxx.api.data.NetworkError
import dev.xxxxx.api.data.Product
import dev.xxxxx.api.data.Province
import dev.xxxxx.api.data.Station


public interface CurrentDataApi {

    public suspend fun getAllStations(): Either<NetworkError, List<Station>>

    public suspend fun getStationsByAutonomy(autonomy: Autonomy): Either<NetworkError, List<Station>>

    public suspend fun getStationsByAutonomyAndProduct(autonomy: Autonomy, product: Product): Either<NetworkError, List<Station>>

    public suspend fun getStationsByCity(city: City): Either<NetworkError, List<Station>>

    public suspend fun getStationsByCityAndProduct(city: City, product: Product): Either<NetworkError, List<Station>>

    public suspend fun getStationsByProduct(product: Product): Either<NetworkError, List<Station>>

    public suspend fun getStationsByProvince(province: Province): Either<NetworkError, List<Station>>

    public suspend fun getStationsByProvinceAndProduct(province: Province, product: Product): Either<NetworkError, List<Station>>
}

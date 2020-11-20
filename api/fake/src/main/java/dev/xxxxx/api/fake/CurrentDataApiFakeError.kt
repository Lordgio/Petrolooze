package dev.xxxxx.api.fake

import arrow.core.Either
import dev.xxxxx.api.CurrentDataApi
import dev.xxxxx.api.data.Autonomy
import dev.xxxxx.api.data.City
import dev.xxxxx.api.data.NetworkError
import dev.xxxxx.api.data.Product
import dev.xxxxx.api.data.Province
import dev.xxxxx.api.data.Station

class CurrentDataApiFakeError : CurrentDataApi {

    override suspend fun getAllStations(): Either<NetworkError, List<Station>> =
        Either.left(NetworkError.GenericError(""))

    override suspend fun getStationsByAutonomy(autonomy: Autonomy): Either<NetworkError, List<Station>> =
        Either.left(NetworkError.GenericError(""))

    override suspend fun getStationsByAutonomyAndProduct(autonomy: Autonomy,
                                                         product: Product): Either<NetworkError, List<Station>> =
        Either.left(NetworkError.GenericError(""))

    override suspend fun getStationsByCity(city: City): Either<NetworkError, List<Station>> =
        Either.left(NetworkError.GenericError(""))

    override suspend fun getStationsByCityAndProduct(city: City, product: Product): Either<NetworkError, List<Station>> =
        Either.left(NetworkError.GenericError(""))

    override suspend fun getStationsByProduct(product: Product): Either<NetworkError, List<Station>> =
        Either.left(NetworkError.GenericError(""))

    override suspend fun getStationsByProvince(province: Province): Either<NetworkError, List<Station>> =
        Either.left(NetworkError.GenericError(""))

    override suspend fun getStationsByProvinceAndProduct(province: Province,
                                                         product: Product): Either<NetworkError, List<Station>> =
        Either.left(NetworkError.GenericError(""))
}
package dev.xxxxx.api.impl

import arrow.core.Either
import dev.xxxxx.api.CurrentDataApi
import dev.xxxxx.api.data.*
import dev.xxxxx.api.impl.data.toAutonomy
import dev.xxxxx.api.impl.data.toStation
import dev.xxxxx.api.impl.mappers.toNetworkError
import dev.xxxxx.api.impl.retrofit.CurrentDataClient

class CurrentDataApiImpl(private val retrofitClient: CurrentDataClient) : CurrentDataApi {

    override suspend fun getAllStations(): Either<NetworkError, List<Station>> = Either.catch {
        retrofitClient
            .getStations()
            .stationList
            .map { it.toStation() }
    }.mapLeft { it.toNetworkError() }

    override suspend fun getStationsByAutonomy(autonomy: Autonomy): Either<NetworkError, List<Station>> = Either.catch {
        retrofitClient
            .getStationsByAutonomy(autonomy.id)
            .stationList
            .map { it.toStation() }
    }.mapLeft { it.toNetworkError() }

    override suspend fun getStationsByAutonomyAndProduct(autonomy: Autonomy, product: Product): Either<NetworkError, List<Station>> = Either.catch {
        retrofitClient
            .getStationsByAutonomyAndProduct(autonomy.id, product.id)
            .stationList
            .map { it.toStation() }
    }.mapLeft { it.toNetworkError() }

    override suspend fun getStationsByCity(city: City): Either<NetworkError, List<Station>> = Either.catch {
        retrofitClient
            .getStationsByCity(city.id)
            .stationList
            .map { it.toStation() }
    }.mapLeft { it.toNetworkError() }

    override suspend fun getStationsByCityAndProduct(city: City, product: Product): Either<NetworkError, List<Station>> = Either.catch {
        retrofitClient
            .getStationsByCityAndProduct(city.id, product.id)
            .stationList
            .map { it.toStation() }
    }.mapLeft { it.toNetworkError() }

    override suspend fun getStationsByProduct(product: Product): Either<NetworkError, List<Station>> = Either.catch {
        retrofitClient
            .getStationsByProduct(product.id)
            .stationList
            .map { it.toStation() }
    }.mapLeft { it.toNetworkError() }

    override suspend fun getStationsByProvince(province: Province): Either<NetworkError, List<Station>> = Either.catch {
        retrofitClient
            .getStationsByProvince(province.provinceId)
            .stationList
            .map { it.toStation() }
    }.mapLeft { it.toNetworkError() }

    override suspend fun getStationsByProvinceAndProduct(province: Province, product: Product): Either<NetworkError, List<Station>> = Either.catch {
        retrofitClient
            .getStationsByProvinceAndProduct(province.provinceId, product.id)
            .stationList
            .map { it.toStation() }
    }.mapLeft { it.toNetworkError() }
}

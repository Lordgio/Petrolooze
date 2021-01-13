package dev.xxxxx.api.impl

import arrow.core.Either
import dev.xxxxx.api.BaseDataApi
import dev.xxxxx.api.data.Autonomy
import dev.xxxxx.api.data.City
import dev.xxxxx.api.data.NetworkError
import dev.xxxxx.api.data.Product
import dev.xxxxx.api.data.Province
import dev.xxxxx.api.impl.data.toAutonomy
import dev.xxxxx.api.impl.data.toCity
import dev.xxxxx.api.impl.data.toProduct
import dev.xxxxx.api.impl.data.toProvince
import dev.xxxxx.api.impl.mappers.toNetworkError
import dev.xxxxx.api.impl.retrofit.BaseDataClient

class BaseDataApiImpl(private val retrofitClient: BaseDataClient) : BaseDataApi {

    override suspend fun getAutonomies(): Either<NetworkError, List<Autonomy>> = Either.catch {
        retrofitClient
            .getAutonomies()
            .map { it.toAutonomy() }
    }.mapLeft { it.toNetworkError() }

    override suspend fun getCities(): Either<NetworkError, List<City>> = Either.catch {
        retrofitClient
            .getCities()
            .map { it.toCity() }
    }.mapLeft { it.toNetworkError() }

    override suspend fun getProducts(): Either<NetworkError, List<Product>> = Either.catch {
        retrofitClient
            .getProducts()
            .map { it.toProduct() }
    }.mapLeft { it.toNetworkError() }

    override suspend fun getProvinces(): Either<NetworkError, List<Province>> = Either.catch {
        retrofitClient
            .getProvinces()
            .map { it.toProvince() }
    }.mapLeft { it.toNetworkError() }
}

package dev.xxxxx.api.fake

import arrow.core.Either
import dev.xxxxx.api.BaseDataApi
import dev.xxxxx.api.data.Autonomy
import dev.xxxxx.api.data.City
import dev.xxxxx.api.data.NetworkError
import dev.xxxxx.api.data.Product
import dev.xxxxx.api.data.Province

class BaseDataApiFakeError  : BaseDataApi {

    override suspend fun getAutonomies(): Either<NetworkError, List<Autonomy>> =
        Either.left(NetworkError.GenericError(""))

    override suspend fun getCities(): Either<NetworkError, List<City>> =
        Either.left(NetworkError.GenericError(""))

    override suspend fun getProducts(): Either<NetworkError, List<Product>> =
        Either.left(NetworkError.GenericError(""))

    override suspend fun getProvinces(): Either<NetworkError, List<Province>> =
        Either.left(NetworkError.GenericError(""))
}
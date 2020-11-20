package dev.xxxxx.api

import arrow.core.Either
import dev.xxxxx.api.data.Autonomy
import dev.xxxxx.api.data.City
import dev.xxxxx.api.data.NetworkError
import dev.xxxxx.api.data.Product
import dev.xxxxx.api.data.Province

public interface BaseDataApi {

    public suspend fun getAutonomies(): Either<NetworkError, List<Autonomy>>

    public suspend fun getCities(): Either<NetworkError, List<City>>

    public suspend fun getProducts(): Either<NetworkError, List<Product>>

    public suspend fun getProvinces(): Either<NetworkError, List<Province>>
}
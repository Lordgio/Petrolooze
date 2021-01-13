package dev.xxxxx.api.fake

import arrow.core.Either
import dev.xxxxx.api.BaseDataApi
import dev.xxxxx.api.data.Autonomy
import dev.xxxxx.api.data.City
import dev.xxxxx.api.data.NetworkError
import dev.xxxxx.api.data.Product
import dev.xxxxx.api.data.Province
import dev.xxxxx.api.fake.mocks.AutonomyMocks
import dev.xxxxx.api.fake.mocks.CityMocks
import dev.xxxxx.api.fake.mocks.ProductMocks
import dev.xxxxx.api.fake.mocks.ProvinceMocks

class BaseDataApiFakeSuccess : BaseDataApi {

    override suspend fun getAutonomies(): Either<NetworkError, List<Autonomy>> = Either.right(listOf(
        AutonomyMocks.autonomy1,
        AutonomyMocks.autonomy2,
        AutonomyMocks.autonomy3
    ))

    override suspend fun getCities(): Either<NetworkError, List<City>> = Either.right(listOf(
        CityMocks.city1,
        CityMocks.city2,
        CityMocks.city3
    ))

    override suspend fun getProducts(): Either<NetworkError, List<Product>> = Either.right(listOf(
        ProductMocks.product1,
        ProductMocks.product2,
        ProductMocks.product3
    ))

    override suspend fun getProvinces(): Either<NetworkError, List<Province>> = Either.right(listOf(
        ProvinceMocks.province1,
        ProvinceMocks.province2,
        ProvinceMocks.province3
    ))

}

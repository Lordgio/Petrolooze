package dev.xxxxx.api.fake

import dev.xxxxx.api.BaseDataApi
import dev.xxxxx.api.data.Autonomy
import dev.xxxxx.api.data.City
import dev.xxxxx.api.data.Product
import dev.xxxxx.api.data.Province
import dev.xxxxx.api.fake.mocks.AutonomyMocks
import dev.xxxxx.api.fake.mocks.CityMocks
import dev.xxxxx.api.fake.mocks.ProductMocks
import dev.xxxxx.api.fake.mocks.ProvinceMocks

class BaseDataApiFake : BaseDataApi {

    override suspend fun getAutonomies(): List<Autonomy> = listOf(
        AutonomyMocks.autonomy1,
        AutonomyMocks.autonomy2,
        AutonomyMocks.autonomy3
    )

    override suspend fun getCities(): List<City> = listOf(
        CityMocks.city1,
        CityMocks.city2,
        CityMocks.city3
    )

    override suspend fun getProducts(): List<Product> = listOf(
        ProductMocks.product1,
        ProductMocks.product2,
        ProductMocks.product3
    )

    override suspend fun getProvinces(): List<Province> = listOf(
        ProvinceMocks.province1,
        ProvinceMocks.province2,
        ProvinceMocks.province3
    )
}

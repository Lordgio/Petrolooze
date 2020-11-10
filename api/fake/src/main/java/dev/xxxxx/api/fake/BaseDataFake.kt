package dev.xxxxx.api.fake

import dev.xxxxx.api.BaseDataApi
import dev.xxxxx.api.data.Autonomy
import dev.xxxxx.api.data.City
import dev.xxxxx.api.data.Product
import dev.xxxxx.api.data.Province
import dev.xxxxx.api.fake.mocks.MockedAutonomies
import dev.xxxxx.api.fake.mocks.MockedCities
import dev.xxxxx.api.fake.mocks.MockedProducts
import dev.xxxxx.api.fake.mocks.MockedProvinces

class BaseDataFake : BaseDataApi {

    override suspend fun getAutonomies(): List<Autonomy> = listOf(
        MockedAutonomies.autonomy1,
        MockedAutonomies.autonomy2,
        MockedAutonomies.autonomy3
    )

    override suspend fun getCities(): List<City> = listOf(
        MockedCities.city1,
        MockedCities.city2,
        MockedCities.city3
    )

    override suspend fun getProducts(): List<Product> = listOf(
        MockedProducts.product1,
        MockedProducts.product2,
        MockedProducts.product3
    )

    override suspend fun getProvinces(): List<Province> = listOf(
        MockedProvinces.province1,
        MockedProvinces.province2,
        MockedProvinces.province3
    )
}

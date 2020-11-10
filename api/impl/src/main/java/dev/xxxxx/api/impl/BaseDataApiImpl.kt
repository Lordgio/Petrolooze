package dev.xxxxx.api.impl

import dev.xxxxx.api.BaseDataApi
import dev.xxxxx.api.data.Autonomy
import dev.xxxxx.api.data.City
import dev.xxxxx.api.data.Product
import dev.xxxxx.api.data.Province
import dev.xxxxx.api.impl.retrofit.BaseDataClient
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BaseDataApiImpl @Inject constructor(private val retrofitClient: BaseDataClient) : BaseDataApi {

    override suspend fun getAutonomies(): List<Autonomy> = retrofitClient.getAutonomies()

    override suspend fun getCities(): List<City> = retrofitClient.getCities()

    override suspend fun getProducts(): List<Product> = retrofitClient.getProducts()

    override suspend fun getProvinces(): List<Province> = retrofitClient.getProvinces()
}

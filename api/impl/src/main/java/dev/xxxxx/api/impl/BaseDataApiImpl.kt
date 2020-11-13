package dev.xxxxx.api.impl

import dev.xxxxx.api.BaseDataApi
import dev.xxxxx.api.data.Autonomy
import dev.xxxxx.api.data.City
import dev.xxxxx.api.data.Product
import dev.xxxxx.api.data.Province
import dev.xxxxx.api.impl.retrofit.BaseDataClient
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.jvm.Throws

@Singleton
class BaseDataApiImpl @Inject constructor(private val retrofitClient: BaseDataClient) : BaseDataApi {

    @Throws(Exception::class)
    override suspend fun getAutonomies(): List<Autonomy> = retrofitClient.getAutonomies()

    @Throws(Exception::class)
    override suspend fun getCities(): List<City> = retrofitClient.getCities()

    @Throws(Exception::class)
    override suspend fun getProducts(): List<Product> = retrofitClient.getProducts()

    @Throws(Exception::class)
    override suspend fun getProvinces(): List<Province> = retrofitClient.getProvinces()
}

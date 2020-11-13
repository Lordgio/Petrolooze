package dev.xxxxx.api.impl

import dev.xxxxx.api.BaseDataApi
import dev.xxxxx.api.data.Autonomy
import dev.xxxxx.api.data.City
import dev.xxxxx.api.data.Product
import dev.xxxxx.api.data.Province
import dev.xxxxx.api.impl.data.toAutonomy
import dev.xxxxx.api.impl.data.toCity
import dev.xxxxx.api.impl.data.toProduct
import dev.xxxxx.api.impl.data.toProvince
import dev.xxxxx.api.impl.retrofit.BaseDataClient
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.jvm.Throws

@Singleton
class BaseDataApiImpl @Inject constructor(private val retrofitClient: BaseDataClient) : BaseDataApi {

    @Throws(Exception::class)
    override suspend fun getAutonomies(): List<Autonomy> =
        retrofitClient
            .getAutonomies()
            .map { it.toAutonomy() }

    @Throws(Exception::class)
    override suspend fun getCities(): List<City> =
        retrofitClient
            .getCities()
            .map { it.toCity() }

    @Throws(Exception::class)
    override suspend fun getProducts(): List<Product> =
        retrofitClient
            .getProducts()
            .map { it.toProduct() }

    @Throws(Exception::class)
    override suspend fun getProvinces(): List<Province> =
        retrofitClient
            .getProvinces()
            .map { it.toProvince() }
}

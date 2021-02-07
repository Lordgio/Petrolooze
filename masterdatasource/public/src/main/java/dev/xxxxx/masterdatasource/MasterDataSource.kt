package dev.xxxxx.masterdatasource

import dev.xxxxx.masterdatasource.data.Autonomy
import dev.xxxxx.masterdatasource.data.City
import dev.xxxxx.masterdatasource.data.Product
import dev.xxxxx.masterdatasource.data.Province
import dev.xxxxx.masterdatasource.data.Resource
import kotlinx.coroutines.flow.SharedFlow

interface MasterDataSource {

    suspend fun getAutonomies(skipCaches: Boolean = false): SharedFlow<Resource<List<Autonomy>>>

    suspend fun getProvinces(skipCaches: Boolean = false): SharedFlow<Resource<List<Province>>>

    suspend fun getCities(skipCaches: Boolean = false): SharedFlow<Resource<List<City>>>

    suspend fun getProducts(skipCaches: Boolean = false): SharedFlow<Resource<List<Product>>>
}
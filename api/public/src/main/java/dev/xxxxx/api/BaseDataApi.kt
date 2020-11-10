package dev.xxxxx.api

import dev.xxxxx.api.data.Autonomy
import dev.xxxxx.api.data.City
import dev.xxxxx.api.data.Product
import dev.xxxxx.api.data.Province

interface BaseDataApi {

    suspend fun getAutonomies(): List<Autonomy>

    suspend fun getCities(): List<City>

    suspend fun getProducts(): List<Product>

    suspend fun getProvinces(): List<Province>
}
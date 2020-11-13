package dev.xxxxx.api

import dev.xxxxx.api.data.Autonomy
import dev.xxxxx.api.data.City
import dev.xxxxx.api.data.Product
import dev.xxxxx.api.data.Province

public interface BaseDataApi {

    public suspend fun getAutonomies(): List<Autonomy>

    public suspend fun getCities(): List<City>

    public suspend fun getProducts(): List<Product>

    public suspend fun getProvinces(): List<Province>
}
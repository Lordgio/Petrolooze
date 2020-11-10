@file:Suppress("SpellCheckingInspection")

package dev.xxxxx.api.impl.retrofit

import dev.xxxxx.api.data.Autonomy
import dev.xxxxx.api.data.City
import dev.xxxxx.api.data.Product
import dev.xxxxx.api.data.Province
import retrofit2.http.GET
import retrofit2.http.Path

interface BaseDataClient {

    @GET("Listados/ComunidadesAutonomas/")
    suspend fun getAutonomies(): List<Autonomy>

    @GET("Listados/Municipios/")
    suspend fun getCities(): List<City>

    @GET("Listados/MunicipiosPorProvincia/{provinceId}/")
    suspend fun getCitiesByProvince(@Path(value = "provinceId", encoded = true) provinceId: String): List<City>

    @GET("Listados/ProductosPetroliferos/")
    suspend fun getProducts(): List<Product>

    @GET("Listados/Provincias/")
    suspend fun getProvinces(): List<Province>

    @GET("Listados/ProvinciasPorComunidad/{ccaaId}/")
    suspend fun getProvincesByAutonomy(@Path(value = "ccaaId", encoded = true) ccaaId: String): List<Province>
}

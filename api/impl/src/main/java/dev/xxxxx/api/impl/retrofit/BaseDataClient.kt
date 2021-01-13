@file:Suppress("SpellCheckingInspection")

package dev.xxxxx.api.impl.retrofit

import dev.xxxxx.api.data.Autonomy
import dev.xxxxx.api.impl.data.ApiAutonomy
import dev.xxxxx.api.impl.data.ApiCity
import dev.xxxxx.api.impl.data.ApiProduct
import dev.xxxxx.api.impl.data.ApiProvince
import retrofit2.http.GET
import retrofit2.http.Path

interface BaseDataClient {

    @GET("Listados/ComunidadesAutonomas/")
    suspend fun getAutonomies(): List<ApiAutonomy>

    @GET("Listados/Municipios/")
    suspend fun getCities(): List<ApiCity>

    @GET("Listados/MunicipiosPorProvincia/{provinceId}/")
    suspend fun getCitiesByProvince(@Path(value = "provinceId", encoded = true) provinceId: String): List<ApiCity>

    @GET("Listados/ProductosPetroliferos/")
    suspend fun getProducts(): List<ApiProduct>

    @GET("Listados/Provincias/")
    suspend fun getProvinces(): List<ApiProvince>

    @GET("Listados/ProvinciasPorComunidad/{ccaaId}/")
    suspend fun getProvincesByAutonomy(@Path(value = "ccaaId", encoded = true) ccaaId: String): List<ApiProvince>
}

package dev.xxxxx.api.impl.retrofit

import dev.xxxxx.api.impl.data.StationResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface CurrentDataClient {

    @GET("EstacionesTerrestres/")
    suspend fun getStations(): StationResponse

    @GET("EstacionesTerrestres/FiltroCCAA/{ccaaId}/")
    suspend fun getStationsByAutonomy(@Path(value = "ccaaId", encoded = true) ccaaId: String): StationResponse

    @GET("EstacionesTerrestres/FiltroCCAAProducto/{ccaaId}/{productId}/")
    suspend fun getStationsByAutonomyAndProduct(@Path(value = "ccaaId", encoded = true) ccaaId: String,
                                                @Path(value = "productId", encoded = true) productId: String): StationResponse

    @GET("EstacionesTerrestres/FiltroMunicipio/{cityId}/")
    suspend fun getStationsByCity(@Path(value = "cityId", encoded = true) cityId: String): StationResponse

    @GET("EstacionesTerrestres/FiltroMunicipioProducto/{cityId}/{productId}/")
    suspend fun getStationsByCityAndProduct(@Path(value = "cityId", encoded = true) cityId: String,
                                            @Path(value = "productId", encoded = true) productId: String): StationResponse

    @GET("EstacionesTerrestres/FiltroProducto/{productId}/")
    suspend fun getStationsByProduct(@Path(value = "productId", encoded = true) productId: String): StationResponse

    @GET("EstacionesTerrestres/FiltroProvincia/{provinceId}/")
    suspend fun getStationsByProvince(@Path(value = "provinceId", encoded = true) provinceId: String): StationResponse

    @GET("EstacionesTerrestres/FiltroProvinciaProducto/{provinceId}/{productId}/")
    suspend fun getStationsByProvinceAndProduct(@Path(value = "provinceId", encoded = true) provinceId: String,
                                                @Path(value = "productId", encoded = true) productId: String): StationResponse
}

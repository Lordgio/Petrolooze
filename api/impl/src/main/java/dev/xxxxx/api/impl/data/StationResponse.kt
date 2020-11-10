package dev.xxxxx.api.impl.data

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class StationResponse (
    @Json(name = "Fecha") val date: String,
    @Json(name = "ListaEESSPrecio") val stationList: List<ApiStation>,
    @Json(name = "Nota") val note: String,
    @Json(name = "ResultadoConsulta") val result: String
)
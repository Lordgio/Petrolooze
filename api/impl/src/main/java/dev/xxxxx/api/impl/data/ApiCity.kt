package dev.xxxxx.api.impl.data


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import dev.xxxxx.api.data.City

@JsonClass(generateAdapter = true)
data class ApiCity(
    @Json(name = "CCAA") val ccaa: String,
    @Json(name = "IDCCAA") val idCCAA: String,
    @Json(name = "IDMunicipio") val idMunicipio: String,
    @Json(name = "IDProvincia") val idProvincia: String,
    @Json(name = "Municipio") val municipio: String,
    @Json(name = "Provincia") val provincia: String
)

fun ApiCity.toCity() = City(
    id = this.idMunicipio,
    provinceId = this.idProvincia,
    autonomyId = this.idCCAA,
    name = this.municipio,
    provinceName = this.provincia,
    autonomyName = this.ccaa
)
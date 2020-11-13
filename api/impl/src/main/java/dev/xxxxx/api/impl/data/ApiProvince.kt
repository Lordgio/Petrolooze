package dev.xxxxx.api.impl.data


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import dev.xxxxx.api.data.Province

@JsonClass(generateAdapter = true)
data class ApiProvince(
    @Json(name = "CCAA") val ccaa: String,
    @Json(name = "IDCCAA") val idCCAA: String,
    @Json(name = "IDPovincia") val idPovincia: String,
    @Json(name = "Provincia") val provincia: String
)

fun ApiProvince.toProvince() = Province(
    provinceId = this.idPovincia,
    autonomyId = this.idCCAA,
    provinceName = this.provincia,
    autonomyName = this.ccaa
)
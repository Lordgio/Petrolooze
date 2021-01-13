package dev.xxxxx.api.impl.data


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import dev.xxxxx.api.data.Autonomy

@JsonClass(generateAdapter = true)
data class ApiAutonomy(
    @Json(name = "CCAA") val ccaa: String,
    @Json(name = "IDCCAA") val idCCAA: String
)

fun ApiAutonomy.toAutonomy() = Autonomy(
    id = this.idCCAA,
    name = this.ccaa
)
package dev.xxxxx.api.impl.data

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import dev.xxxxx.api.data.Station

@JsonClass(generateAdapter = true)
data class ApiStation(
    @Json(name = "% BioEtanol") val bioethanolPercent: String,
    @Json(name = "C.P.") val postalCode: String,
    @Json(name = "Dirección") val address: String,
    @Json(name = "Horario") val timetable: String,
    @Json(name = "IDCCAA") val autonomyId: String,
    @Json(name = "IDEESS") val id: String,
    @Json(name = "IDMunicipio") val cityId: String,
    @Json(name = "IDProvincia") val provinceId: String,
    @Json(name = "Latitud") val latitude: String,
    @Json(name = "Localidad") val cityName: String,
    @Json(name = "Longitud (WGS84)") val longitude: String,
    @Json(name = "Margen") val margin: String,
    @Json(name = "Precio Biodiesel") val biodieselPrice: String,
    @Json(name = "Precio Bioetanol") val bioethanolPrice: String,
    @Json(name = "Precio Gas Natural Comprimido") val gncPrice: String,
    @Json(name = "Precio Gas Natural Licuado") val gnlPrice: String,
    @Json(name = "Precio Gases licuados del petróleo") val glpPrice: String,
    @Json(name = "Precio Gasoleo A") val aGasPrice: String,
    @Json(name = "Precio Gasoleo B") val bGasPrice: String,
    @Json(name = "Precio Gasoleo Premium") val premiumGasPrice: String,
    @Json(name = "Precio Gasolina 95 E10") val gas95E10Price: String,
    @Json(name = "Precio Gasolina 95 E5") val gas95E5Price: String,
    @Json(name = "Precio Gasolina 95 E5 Premium") val premiumGas95E5Price: String,
    @Json(name = "Precio Gasolina 98 E10") val gas98E10Price: String,
    @Json(name = "Precio Gasolina 98 E5") val gas98E5Price: String,
    @Json(name = "Precio Hidrogeno") val hydrogenPrice: String,
    @Json(name = "Provincia") val provinceName: String,
    @Json(name = "Remisión") val remision: String,
    @Json(name = "Rótulo") val label: String,
    @Json(name = "Tipo Venta") val saleType: String,
    @Json(name = "% Éster metílico") val methylicEsterPercent: String
)

fun ApiStation.toStation(): Station = Station(
    postalCode = this.postalCode,
    address = this.address,
    timetable = this.timetable,
    latitude = this.latitude.toLongOrNull() ?: 0L,
    longitude = this.longitude.toLongOrNull() ?: 0L,
    margin = this.margin,
    cityName = this.cityName,
    biodieselPrice = this.biodieselPrice.toDoubleOrNull() ?: 0.0,
    bioethanolPrice = this.bioethanolPrice.toDoubleOrNull() ?: 0.0,
    gncPrice = this.gncPrice.toDoubleOrNull() ?: 0.0,
    gnlPrice = this.gnlPrice.toDoubleOrNull() ?: 0.0,
    glpPrice = this.glpPrice.toDoubleOrNull() ?: 0.0,
    aGasPrice = this.aGasPrice.toDoubleOrNull() ?: 0.0,
    bGasPrice = this.bGasPrice.toDoubleOrNull() ?: 0.0,
    premiumGasPrice = this.premiumGasPrice.toDoubleOrNull() ?: 0.0,
    gas95E10Price = this.gas95E10Price.toDoubleOrNull() ?: 0.0,
    gas95E5Price = this.gas95E5Price.toDoubleOrNull() ?: 0.0,
    premiumGas95E5Price = this.premiumGas95E5Price.toDoubleOrNull() ?: 0.0,
    gas98E10Price = this.gas98E10Price.toDoubleOrNull() ?: 0.0,
    gas98E5Price = this.gas98E5Price.toDoubleOrNull() ?: 0.0,
    hydrogenPrice = this.hydrogenPrice.toDoubleOrNull() ?: 0.0,
    provinceName = this.provinceName,
    remision = this.remision,
    label = this.label,
    saleType = this.saleType,
    bioethanolPercent = this.bioethanolPercent.toDoubleOrNull() ?: 0.0,
    methylicEsterPercent = this.methylicEsterPercent.toDoubleOrNull() ?: 0.0,
    id = this.id,
    cityId = this.cityId,
    provinceId = this.provinceId,
    autonomyId = this.autonomyId
)

package dev.xxxxx.api.impl.data


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import dev.xxxxx.api.data.Product

@JsonClass(generateAdapter = true)
data class ApiProduct(
    @Json(name = "IDProducto") val idProducto: String,
    @Json(name = "NombreProducto") val nombreProducto: String,
    @Json(name = "NombreProductoAbreviatura") val nombreProductoAbreviatura: String
)

fun ApiProduct.toProduct() = Product(
    id = this.idProducto,
    name = this.nombreProducto,
    abbreviation = this.nombreProductoAbreviatura
)
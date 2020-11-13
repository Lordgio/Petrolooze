package dev.xxxxx.api.data

public data class Station(
    val postalCode: String,
    val address: String,
    val timetable: String,
    val latitude: Long,
    val longitude: Long,
    val margin: String,
    val cityName: String,
    val biodieselPrice: Double,
    val bioethanolPrice: Double,
    val gncPrice: Double,
    val gnlPrice: Double,
    val glpPrice: Double,
    val aGasPrice: Double,
    val bGasPrice: Double,
    val premiumGasPrice: Double,
    val gas95E10Price: Double,
    val gas95E5Price: Double,
    val premiumGas95E5Price: Double,
    val gas98E10Price: Double,
    val gas98E5Price: Double,
    val hydrogenPrice: Double,
    val provinceName: String,
    val remision: String,
    val label: String,
    val saleType: String,
    val bioethanolPercent: Double,
    val methylicEsterPercent: Double,
    val id: String,
    val cityId: String,
    val provinceId: String,
    val autonomyId: String,
)

package dev.xxxxx.currentdatasource.data

sealed class SearchFeature(open val id: String, open val name: String) {

    data class City(
        override val id: String,
        override val name: String,
        val provinceId: String,
        val provinceName: String,
        val autonomyId: String,
        val autonomyName: String
    ) : SearchFeature(id, name)

    data class Province(
        override val id: String,
        override val name: String,
        val autonomyId: String,
        val autonomyName: String) : SearchFeature(id, name)

    data class Autonomy(
        override val id: String,
        override val name: String) : SearchFeature(id, name)

    data class Product(
        override val id: String,
        override val name: String,
        val abbreviation: String) : SearchFeature(id, name)

}

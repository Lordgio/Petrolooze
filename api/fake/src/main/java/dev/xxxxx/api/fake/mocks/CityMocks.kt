package dev.xxxxx.api.fake.mocks

import dev.xxxxx.api.data.City

object CityMocks {
    val city1 = City(
        id = "3656",
        provinceId = "24",
        autonomyId = "08",
        name = "Ercina (La)",
        provinceName = "LEÓN",
        autonomyName = "Castilla y León"
    )

    val city2 = City(
        id = "5258",
        provinceId = "35",
        autonomyId = "05",
        name = "Telde",
        provinceName = "PALMAS (LAS)",
        autonomyName = "Canarias"
    )

    val city3 = City(
        id = "7411",
        provinceId = "47",
        autonomyId = "08",
        name = "Valoria la Buena",
        provinceName = "VALLADOLID",
        autonomyName = "Castilla y León"
    )
}

package dev.xxxxx.api.fake.mocks

import dev.xxxxx.api.data.Product

object ProductMocks {
    val product1 = Product(
        id = "5",
        name = "Gasóleo Premium",
        abbreviation = "GOA+"
    )

    val product2 = Product(
        id = "22",
        name = "Hidrógeno",
        abbreviation = "H2"
    )

    val product3 = Product(
        id = "13",
        name = "Queroseno de aviación JET_A1",
        abbreviation = "JETA1"
    )
}

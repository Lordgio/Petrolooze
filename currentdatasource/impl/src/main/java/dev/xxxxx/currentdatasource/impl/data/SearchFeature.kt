package dev.xxxxx.currentdatasource.impl.data

import dev.xxxxx.currentdatasource.data.SearchFeature
import dev.xxxxx.api.data.Autonomy as ApiAutonomy
import dev.xxxxx.api.data.City as ApiCity
import dev.xxxxx.api.data.Product as ApiProduct
import dev.xxxxx.api.data.Province as ApiProvince

fun SearchFeature.Autonomy.toAutonomy(): ApiAutonomy {
    return ApiAutonomy(this.id, this.name)
}

fun SearchFeature.City.toCity(): ApiCity {
    return ApiCity(
        id = id,
        provinceId = provinceId,
        autonomyId = autonomyId,
        name = name,
        provinceName = provinceName,
        autonomyName = autonomyName
    )
}

fun SearchFeature.Province.toProvince(): ApiProvince {
    return ApiProvince(
        provinceId = id,
        autonomyId = autonomyId,
        provinceName = name,
        autonomyName = autonomyName
    )
}

fun SearchFeature.Product.toProduct(): ApiProduct {
    return ApiProduct(
        id = id,
        name = name,
        abbreviation = abbreviation
    )
}
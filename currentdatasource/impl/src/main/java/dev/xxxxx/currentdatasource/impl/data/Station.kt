package dev.xxxxx.currentdatasource.impl.data

import dev.xxxxx.api.data.Station as ApiStation
import dev.xxxxx.currentdatasource.data.Station

fun ApiStation.toStation(): Station {
    return Station()
}
package dev.xxxxx.feature1.di

import dev.xxxxx.feature1.StationItemAdapter
import org.koin.dsl.module

val stationListModule = module {

    single { StationItemAdapter() }

}

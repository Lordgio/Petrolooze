package dev.xxxxx.feature1.di

import dev.xxxxx.domainfeature1.Station
import dev.xxxxx.feature1.StationItemAdapter
import dev.xxxxx.feature1.StationListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val stationListModule = module {

    viewModel { StationListViewModel() }
    single { (click: (Station) -> Unit) -> StationItemAdapter(click) }

}

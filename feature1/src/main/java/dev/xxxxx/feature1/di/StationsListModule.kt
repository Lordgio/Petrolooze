package dev.xxxxx.feature1.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import dev.xxxxx.feature1.StationItemAdapter

@Module
@InstallIn(FragmentComponent::class)
internal class StationsListModule {

    @Provides
    fun provideStationItemAdapter(): StationItemAdapter = StationItemAdapter()
}
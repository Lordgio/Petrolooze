package dev.xxxxx.petrolooze.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dev.xxxxx.api.BaseDataApi
import dev.xxxxx.api.CurrentDataApi
import dev.xxxxx.api.HistoricalDataApi
import dev.xxxxx.api.impl.BaseDataApiImpl
import dev.xxxxx.api.impl.CurrentDataApiImpl
import dev.xxxxx.api.impl.HistoricalDataApiImpl

@Module
@InstallIn(ApplicationComponent::class)
class AppModule {

    @Provides
    fun provideBaseDataApi(impl: BaseDataApiImpl): BaseDataApi = impl

    @Provides
    fun provideCurrentDataApi(impl: CurrentDataApiImpl): CurrentDataApi = impl

    @Provides
    fun provideHistoricalDataApi(impl: HistoricalDataApiImpl): HistoricalDataApi = impl
}

package dev.xxxxx.api.impl.di

import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dev.xxxxx.api.impl.BaseDataApiImpl
import dev.xxxxx.api.impl.CurrentDataApiImpl
import dev.xxxxx.api.impl.HistoricalDataApiImpl
import dev.xxxxx.api.impl.retrofit.BaseDataClient
import dev.xxxxx.api.impl.retrofit.CurrentDataClient
import dev.xxxxx.api.impl.retrofit.HistoricalDataClient
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class ApiModule {

    companion object {
        private const val TIMEOUT = 30L
    }

    @Provides
    fun provideBaseUrl(): String =
        "https://sedeaplicaciones.minetur.gob.es/ServiciosRESTCarburantes/PreciosCarburantes/"

    @Provides
    @Singleton
    fun provideJsonParser(): Moshi = Moshi.Builder().build()

    @Provides
    @Singleton
    fun provideRestClient(): OkHttpClient = OkHttpClient.Builder()
        .readTimeout(TIMEOUT, TimeUnit.SECONDS)
        .connectTimeout(TIMEOUT, TimeUnit.SECONDS)
        .build()

    @Provides
    @Singleton
    fun provideRetrofitInstance(baseUrl: String, restClient: OkHttpClient,
                                jsonParser: Moshi): Retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .client(restClient)
        .addConverterFactory(MoshiConverterFactory.create(jsonParser))
        .build()

    @Provides
    @Singleton
    fun provideBaseDataClient(retrofit: Retrofit): BaseDataClient =
        retrofit.create(BaseDataClient::class.java)

    @Provides
    @Singleton
    fun provideCurrentDataClient(retrofit: Retrofit): CurrentDataClient =
        retrofit.create(CurrentDataClient::class.java)

    @Provides
    @Singleton
    fun provideHistoricalDataClient(retrofit: Retrofit): HistoricalDataClient =
        retrofit.create(HistoricalDataClient::class.java)

    @Provides
    fun provideBaseDataApi(client: BaseDataClient): BaseDataApiImpl = BaseDataApiImpl(client)

    @Provides
    fun provideCurrentDataApi(client: CurrentDataClient): CurrentDataApiImpl = CurrentDataApiImpl(client)

    @Provides
    fun provideHistoricalDataApi(client: HistoricalDataClient): HistoricalDataApiImpl = HistoricalDataApiImpl(client)
}

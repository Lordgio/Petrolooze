package dev.xxxxx.masterdatasource.impl

import arrow.core.getOrElse
import dev.xxxxx.api.BaseDataApi
import dev.xxxxx.db.BaseDataDb
import dev.xxxxx.masterdatasource.MasterDataSource
import dev.xxxxx.masterdatasource.data.Autonomy
import dev.xxxxx.masterdatasource.data.City
import dev.xxxxx.masterdatasource.data.Error
import dev.xxxxx.masterdatasource.data.Product
import dev.xxxxx.masterdatasource.data.Province
import dev.xxxxx.masterdatasource.data.Resource
import dev.xxxxx.masterdatasource.data.Source
import dev.xxxxx.masterdatasource.impl.cache.BaseDataCache
import dev.xxxxx.masterdatasource.impl.data.toResource
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject

class MasterDataSourceImpl @Inject constructor(private val api: BaseDataApi, private val db: BaseDataDb,
                                               private val cache: BaseDataCache) : MasterDataSource {

    override suspend fun getAutonomies(skipCaches: Boolean) = MutableSharedFlow<Resource<List<Autonomy>>>()
        /*.apply {
            onEach(::saveData)

            onStart {
                when {
                    skipCaches -> this.emit(api.getAutonomies().toResource(Source.Remote, mapper = { it.bimap({ Error() }, { listOf() }) }))
                    cache.autonomies.isNotEmpty() -> this.emit(cache.autonomies.toResource(Source.Cache))
                    else -> {
                        val dbData = db.getAutonomies()

                        if (dbData.isNotEmpty()) {
                            this.emit(db.getAutonomies().toResource(Source.Database))
                        } else {
                            this.emit(api.getAutonomies().toResource(Source.Remote, mapper = { it.bimap({ Error() }, { listOf() }) }))
                        }
                    }
                }
            }
        }*/
        .asSharedFlow()

    override suspend fun getProvinces(skipCaches: Boolean): SharedFlow<Resource<List<Province>>> {
        TODO("Not yet implemented")
    }

    override suspend fun getCities(skipCaches: Boolean): SharedFlow<Resource<List<City>>> {
        TODO("Not yet implemented")
    }

    override suspend fun getProducts(skipCaches: Boolean): SharedFlow<Resource<List<Product>>> {
        TODO("Not yet implemented")
    }

    /*private fun <T> saveData(resource: Resource<List<T>>) = when(resource.source) {
        Source.Cache -> { /* no-op */ }
        Source.Database -> {
            // Save values in cache
            val data = resource.data.getOrElse { listOf() }
            cache.saveToCache(data)
        }
        Source.Remote -> {
            // Save values in db and cache
            val data = resource.data.getOrElse { listOf() }
            cache.saveToCache(data)
            db.saveAutonomies(data)
        }
    }*/

}
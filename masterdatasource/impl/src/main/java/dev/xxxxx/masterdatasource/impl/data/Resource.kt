package dev.xxxxx.masterdatasource.impl.data

import arrow.core.Either
import dev.xxxxx.masterdatasource.data.Error
import dev.xxxxx.masterdatasource.data.Resource
import dev.xxxxx.masterdatasource.data.Source

fun <A, B, T> Either<A, B>.toResource(source: Source, mapper: (Either<A, B>) -> Either<Error, T>): Resource<T> = Resource(source, mapper.invoke(this))

fun <T> List<T>.toResource(source: Source): Resource<List<T>> = Resource(source, Either.right(this))
package dev.xxxxx.masterdatasource.data

import arrow.core.Either

data class Resource<T>(
    val source: Source,
    val data: Either<Error, T>
)
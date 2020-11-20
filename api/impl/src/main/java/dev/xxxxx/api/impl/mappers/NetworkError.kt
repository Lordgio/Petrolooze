package dev.xxxxx.api.impl.mappers

import dev.xxxxx.api.data.NetworkError
import retrofit2.HttpException
import java.net.SocketTimeoutException

fun Throwable.toNetworkError(): NetworkError {
    return when(this) {
        is SocketTimeoutException -> NetworkError.TimeOut
        is HttpException -> NetworkError.HttpError(this.stackTraceToString())
        else -> NetworkError.GenericError(this.stackTraceToString())
    }
}
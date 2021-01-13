package dev.xxxxx.api.data

public sealed class NetworkError {

    public class GenericError(stacktrace: String) : NetworkError()
    public object TimeOut : NetworkError()
    public class HttpError(stacktrace: String): NetworkError()
}
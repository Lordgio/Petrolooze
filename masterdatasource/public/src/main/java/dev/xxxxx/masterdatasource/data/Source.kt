package dev.xxxxx.masterdatasource.data

sealed class Source {
    object Cache : Source()
    object Database : Source()
    object Remote : Source()
}
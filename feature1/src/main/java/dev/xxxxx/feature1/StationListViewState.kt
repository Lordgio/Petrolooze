package dev.xxxxx.feature1

internal sealed class StationListViewState {
    class Loading(val isLoading: Boolean): StationListViewState()
    object Error: StationListViewState()
}
package dev.xxxxx.feature1

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.xxxxx.domainfeature1.Station
import dev.xxxxx.uiextensions.Event
import dev.xxxxx.uiextensions.asLiveData
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

internal class StationListViewModel: ViewModel() {

    private val stationsFake = listOf(
        Station("1", "Repsol", "CR CM-219, 4,9 - Mondéjar - Guadalajara", "1,209", "1,309", "1,089", "1,139"),
        Station("2", "Repsol", "CR CM-219, 4,9 - Mondéjar - Guadalajara", "1,209", "1,309", "1,089", "1,139"),
        Station("3", "Repsol", "CR CM-219, 4,9 - Mondéjar - Guadalajara", "1,209", "1,309", "1,089", "1,139"),
        Station("4", "Repsol", "CR CM-219, 4,9 - Mondéjar - Guadalajara", "1,209", "1,309", "1,089", "1,139"),
        Station("5", "Repsol", "CR CM-219, 4,9 - Mondéjar - Guadalajara", "1,209", "1,309", "1,089", "1,139"),
        Station("6", "Repsol", "CR CM-219, 4,9 - Mondéjar - Guadalajara", "1,209", "1,309", "1,089", "1,139"),
        Station("7", "Repsol", "CR CM-219, 4,9 - Mondéjar - Guadalajara", "1,209", "1,309", "1,089", "1,139"),
        Station("8", "Repsol", "CR CM-219, 4,9 - Mondéjar - Guadalajara", "1,209", "1,309", "1,089", "1,139"),
        Station("9", "Repsol", "CR CM-219, 4,9 - Mondéjar - Guadalajara", "1,209", "1,309", "1,089", "1,139"),
        Station("10", "Repsol", "CR CM-219, 4,9 - Mondéjar - Guadalajara", "1,209", "1,309", "1,089", "1,139"),
        Station("11", "Repsol", "CR CM-219, 4,9 - Mondéjar - Guadalajara", "1,209", "1,309", "1,089", "1,139"),
        Station("12", "Repsol", "CR CM-219, 4,9 - Mondéjar - Guadalajara", "1,209", "1,309", "1,089", "1,139"),
        Station("13", "Repsol", "CR CM-219, 4,9 - Mondéjar - Guadalajara", "1,209", "1,309", "1,089", "1,139"),
        Station("14", "Repsol", "CR CM-219, 4,9 - Mondéjar - Guadalajara", "1,209", "1,309", "1,089", "1,139"),
        Station("15", "Repsol", "CR CM-219, 4,9 - Mondéjar - Guadalajara", "1,209", "1,309", "1,089", "1,139"),
        Station("16", "Repsol", "CR CM-219, 4,9 - Mondéjar - Guadalajara", "1,209", "1,309", "1,089", "1,139"),
        Station("17", "Repsol", "CR CM-219, 4,9 - Mondéjar - Guadalajara", "1,209", "1,309", "1,089", "1,139"),
        Station("18", "Repsol", "CR CM-219, 4,9 - Mondéjar - Guadalajara", "1,209", "1,309", "1,089", "1,139"),
    )

    private val _viewState = MutableLiveData<Event<StationListViewState>>()
    val viewState = _viewState.asLiveData()

    private val _stations = MutableLiveData<List<Station>>()
    val stations = _stations.asLiveData()

    fun loadData(){
        viewModelScope.launch {
            _stations.value = listOf()
            _viewState.value = Event(StationListViewState.Loading(true))
            delay(3000)
            _viewState.value = Event(StationListViewState.Loading(false))
            _stations.value = stationsFake
            delay(3000)
            _viewState.value = Event(StationListViewState.Error)
        }
    }

}
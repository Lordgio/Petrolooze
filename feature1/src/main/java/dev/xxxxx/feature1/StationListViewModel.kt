package dev.xxxxx.feature1

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.xxxxx.domainfeature1.Station
import dev.xxxxx.uiextensions.Event
import dev.xxxxx.uiextensions.asLiveData
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

internal class StationListViewModel @ViewModelInject constructor(): ViewModel() {

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


    private val _stations = MutableLiveData<List<Station>>()
    val stations = _stations.asLiveData()

    private val _isLoading = MutableLiveData<Event<Boolean>>()
    val isLoading = _isLoading.asLiveData()

    private val _isError = MutableLiveData<Event<Boolean>>()
    val isError = _isError.asLiveData()

    fun loadData(){
        viewModelScope.launch {
            _stations.value = listOf()
            delay(1000)
            _stations.value = stationsFake
            delay(3000)
            _isError.value = Event(true)
        }
    }

}
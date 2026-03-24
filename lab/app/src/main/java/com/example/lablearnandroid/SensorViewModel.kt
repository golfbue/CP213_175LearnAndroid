package com.example.lablearnandroid

import android.app.Application
import android.location.Location
import androidx.lifecycle.AndroidViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class SensorViewModel(application: Application) : AndroidViewModel(application) {

    private val locationTracker = LocationTracker(application)

    // Using StateFlow for location as described in the assignment
    private val _sensorData = MutableStateFlow<Location?>(null)
    val sensorData: StateFlow<Location?> = _sensorData.asStateFlow()

    fun startTracking() {
        locationTracker.startTracking { location ->
            // Whenever hardware sends new data, update the ViewModel's state
            _sensorData.value = location
        }
    }

    fun stopTracking() {
        locationTracker.stopTracking()
    }

    override fun onCleared() {
        super.onCleared()
        // Always clean up hardware listeners to avoid memory leaks
        stopTracking()
    }
}

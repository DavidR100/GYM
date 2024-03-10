package com.davidr10.gym.workout

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class WorkoutViewModel @Inject constructor(): ViewModel() {
    var state by mutableStateOf(WorkoutState())
        private set

    fun onEvent (event: WorkoutEvent){
        when(event){
            is WorkoutEvent.ChangeWeight -> state = state.copy(weigth = event.weight)
        }
    }
}
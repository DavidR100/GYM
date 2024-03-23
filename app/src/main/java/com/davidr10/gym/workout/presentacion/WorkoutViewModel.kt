package com.davidr10.gym.workout.presentacion

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.davidr10.gym.workout.domain.usecase.GetNextWorkouUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WorkoutViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val getNextWorkouUseCase: GetNextWorkouUseCase
): ViewModel() {
    var state by mutableStateOf(WorkoutState())
        private set

    init {
        val routineId = savedStateHandle.get<String>("routineId") ?: ""
        viewModelScope.launch {
            val workout = getNextWorkouUseCase(routineId)
            println(workout)
            println()
        }
    }

    fun onEvent (event: WorkoutEvent){
        when(event){
            is WorkoutEvent.ChangeWeight -> state = state.copy(weigth = event.weight)
        }
    }
}
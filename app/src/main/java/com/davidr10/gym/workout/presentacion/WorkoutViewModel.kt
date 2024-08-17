package com.davidr10.gym.workout.presentacion

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.davidr10.gym.workout.domain.usecase.CreateWorkoutUseCase
import com.davidr10.gym.workout.domain.usecase.GetNextWorkouIdUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WorkoutViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val getNextWorkouIdUseCase: GetNextWorkouIdUseCase,
    private val createWorkoutUseCase: CreateWorkoutUseCase
): ViewModel() {
    var state by mutableStateOf(WorkoutState())
        private set

    init {
        val routineId = savedStateHandle.get<String>("routineId") ?: ""
        viewModelScope.launch {
            val workoutId = getNextWorkouIdUseCase(routineId)
            val workout = createWorkoutUseCase(workoutId)
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
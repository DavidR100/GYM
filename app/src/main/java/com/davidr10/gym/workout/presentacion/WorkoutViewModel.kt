package com.davidr10.gym.workout.presentacion

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.davidr10.gym.core.domain.model.WorkoutLog
import com.davidr10.gym.workout.domain.usecase.CreateWorkoutUseCase
import com.davidr10.gym.workout.domain.usecase.FinishWorkoutUseCase
import com.davidr10.gym.workout.domain.usecase.GetNextWorkouIdUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.util.UUID
import javax.inject.Inject

@HiltViewModel
class WorkoutViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val getNextWorkouIdUseCase: GetNextWorkouIdUseCase,
    private val createWorkoutUseCase: CreateWorkoutUseCase,
    private val finishWorkoutUseCase: FinishWorkoutUseCase
) : ViewModel() {
    var state by mutableStateOf(WorkoutState())
        private set

    init {
        val routineId = savedStateHandle.get<String>("routineId") ?: ""
        viewModelScope.launch {
            val workoutId = getNextWorkouIdUseCase(routineId)
            val workout = createWorkoutUseCase(workoutId)
            state = state.copy(workout = workout, routineId = routineId)
        }
    }

    fun onEvent(event: WorkoutEvent) {
        when (event) {
            is WorkoutEvent.ChangeWeight -> state = state.copy(weigth = event.weight)
            WorkoutEvent.FinishWorkout -> {
                viewModelScope.launch {
                    val workoutLog = WorkoutLog(
                        id = null,
                        bodyWeight = state.weigth.toDouble(),
                        date = state.date,
                        workout = state.workout
                    )
                    finishWorkoutUseCase(state.routineId, workoutLog)
                }
            }
        }
    }
}
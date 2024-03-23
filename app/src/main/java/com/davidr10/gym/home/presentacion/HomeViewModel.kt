package com.davidr10.gym.home.presentacion

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.davidr10.gym.core.domain.model.Exercise
import com.davidr10.gym.core.domain.model.Routine
import com.davidr10.gym.core.domain.model.Workout
import com.davidr10.gym.core.domain.model.WorkoutSet
import com.davidr10.gym.home.domain.usecase.GetRoutinesUseCase
import com.davidr10.gym.home.domain.usecase.InsertRoutinesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getRoutinesUseCase: GetRoutinesUseCase,
    private val insertRoutinesUseCase: InsertRoutinesUseCase
) : ViewModel() {
    var state by mutableStateOf(HomeState())
        private set

    init {
        viewModelScope.launch {
            getRoutinesUseCase().collectLatest {
                state = state.copy(
                    routine = it
                )
            }
        }

            /*val setsA = listOf(
                WorkoutSet(
                    id = 1,
                    weight = 10.0,
                    repetitions = 15
                ),
                WorkoutSet(
                    id = 2,
                    weight = 10.0,
                    repetitions = 30
                )
            )

            val exercisesA = listOf(
                Exercise(
                    id = "exa1",
                    "Bench Press",
                    sets = setsA
                ),

                Exercise(
                    id = "exa2",
                    "Deadlift",
                    sets = setsA
                )
            )

            val setsB = listOf(
                WorkoutSet(
                    id = 1,
                    weight = 10.0,
                    repetitions = 15
                ),
                WorkoutSet(
                    id = 2,
                    weight = 10.0,
                    repetitions = 30
                )
            )

            val exercisesB = listOf(
                Exercise(
                    id = "exb1",
                    "Squats",
                    sets = setsB
                ),

                Exercise(
                    id = "exb2",
                    "Deadlift",
                    sets = setsB
                )
            )

            val workouts = listOf(
                Workout(
                    "workouta",
                    "Workout A",
                    exercisesA
                ),
                Workout(
                    "workoutb",
                    "Workout B",
                    exercisesB
                )
            )

            val routine = Routine(
                "routine1",
                "3x Workout BASE DE DATOS",
                workouts = workouts
            )
            viewModelScope.launch {
                try {
                    insertRoutinesUseCase(routine)
                } catch (e: Exception) {
                    println(e)
                    println()
                }
                println()
            }*/

    }
}
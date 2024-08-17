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

        /*val setsA1 = listOf(
            WorkoutSet(
                id = 1,
                weight = 12.0,
                repetitions = 13
            ),
            WorkoutSet(
                id = 2,
                weight = 14.0,
                repetitions = 15
            )
        )

    val setsA2 = listOf(
        WorkoutSet(
            id = 3,
            weight = 16.0,
            repetitions = 17
        ),
        WorkoutSet(
            id = 4,
            weight = 18.0,
            repetitions = 19
        )
    )

        val exercisesA = listOf(
            Exercise(
                id = "exa1",
                "Bench Press",
                sets = setsA1
            ),

            Exercise(
                id = "exa2",
                "Deadlift",
                sets = setsA2
            )
        )

        val setsB1 = listOf(
            WorkoutSet(
                id = 5,
                weight = 20.0,
                repetitions = 21
            ),
            WorkoutSet(
                id = 6,
                weight = 22.0,
                repetitions = 23
            )
        )

    val setsB2 = listOf(
        WorkoutSet(
            id = 7,
            weight = 24.0,
            repetitions = 25
        ),
        WorkoutSet(
            id = 8,
            weight = 26.0,
            repetitions = 27
        )
    )


        val exercisesB = listOf(
            Exercise(
                id = "exb1",
                "Squats",
                sets = setsB1
            ),

            Exercise(
                id = "exb2",
                "Deadlift",
                sets = setsB2
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
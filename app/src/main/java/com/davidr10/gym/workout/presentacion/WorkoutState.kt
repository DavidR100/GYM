package com.davidr10.gym.workout.presentacion

import com.davidr10.gym.core.domain.model.Workout
import java.time.LocalDate

data class WorkoutState(
    val workout: Workout = Workout("", "", listOf()),
    val date: LocalDate = LocalDate.now(),
    val weigth: String = "0.0",
    val routineId: String = ""
)

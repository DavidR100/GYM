package com.davidr10.gym.workout.presentacion

import com.davidr10.gym.core.domain.model.Workout
import java.time.LocalDate

data class WorkoutState(
    val workout: Workout = Workout(null, "", listOf()),
    val date: LocalDate = LocalDate.now(),
    val bodyWeight: String = "0.0",
    val routineId: Long = -1L
)

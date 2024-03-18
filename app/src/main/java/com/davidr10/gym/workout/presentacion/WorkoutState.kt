package com.davidr10.gym.workout.presentacion

import com.davidr10.gym.core.domain.model.Workout
import java.time.LocalDate

data class WorkoutState(
    val workout: Workout? = null,
    val today: LocalDate = LocalDate.now(),
    val weigth: String = "0.0"
)

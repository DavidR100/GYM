package com.davidr10.gym.core.domain.model

import java.time.LocalDate

data class WorkoutLog(
    val id: Long?,
    val bodyWeight: Double,
    val date: LocalDate,
    val workout: Workout
)

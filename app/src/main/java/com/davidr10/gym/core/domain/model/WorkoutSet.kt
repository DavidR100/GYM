package com.davidr10.gym.core.domain.model

data class WorkoutSet(
    val id: Long?,
    val weight: Double,
    val repetitions: Int
    // TODO: Add min and max reps, para automatic progressive overload
    // TODO: Add rest time in seconds
)

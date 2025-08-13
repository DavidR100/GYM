package com.davidr10.gym.core.domain.model

data class Routine(
    val id: Long?,
    val name: String, // Workout A, Workout B
    val workouts: List<Workout>
    // TODO: Add Routine Image
    // TODO: Add Description
    // TODO: Add Longevity (Time it tokes to finish)
    // TODO: Add Days per week
)

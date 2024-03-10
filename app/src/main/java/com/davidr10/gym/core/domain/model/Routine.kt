package com.davidr10.gym.core.domain.model

data class Routine(
    val id: String,
    val name: String, // Workout A, Workout B
    val workouts: List<Workout>
)

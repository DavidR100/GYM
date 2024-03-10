package com.davidr10.gym.core.domain.model

data class Workout(
    val id: String,
    val name: String, // 3x por semana ...5x por semana
    val exercises: List<Exercise>
)

package com.davidr10.gym.core.domain.model

data class Exercise(
    val id: Long? = null,
    val name: String, //BenchPress
    val sets: List<WorkoutSet>
    // TODO: Add Exercise Image
    // TODO: Add if its cardio. Add time it tokens to finish
)

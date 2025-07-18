package com.davidr10.gym.core.domain.model

data class Exercise (
    val id: Long? = null,
    val name: String, //BenchPress
    val sets: List<WorkoutSet>
    )

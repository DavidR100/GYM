package com.davidr10.gym.workout

sealed interface WorkoutEvent {
    data class ChangeWeight(val weight: String): WorkoutEvent
}
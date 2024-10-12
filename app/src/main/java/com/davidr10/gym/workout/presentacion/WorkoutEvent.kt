package com.davidr10.gym.workout.presentacion

sealed interface WorkoutEvent {
    data class ChangeWeight(val weight: String): WorkoutEvent
    object FinishWorkout : WorkoutEvent
}
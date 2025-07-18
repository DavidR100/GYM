package com.davidr10.gym.workout.domain.usecase

import com.davidr10.gym.core.domain.model.Workout
import com.davidr10.gym.workout.domain.repository.WorkoutRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.util.UUID

class CreateWorkoutUseCase(private val repository: WorkoutRepository) {
    suspend operator fun invoke(workoutId: Long): Workout {
        val workoutLogWorkout = repository.getLastWorkoutLogWorkout(workoutId)
        return workoutLogWorkout ?: repository.getWorkoutById(workoutId)
    }
}
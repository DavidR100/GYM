package com.davidr10.gym.workout.domain.usecase

import com.davidr10.gym.core.domain.model.Workout
import com.davidr10.gym.workout.domain.repository.WorkoutRepository

class GetNextWorkouUseCase(private val repository: WorkoutRepository) {
    suspend operator fun invoke(routineId: String): Workout {
        return repository.getNextWorkoutsByRoutine(routineId).first()
    }
}
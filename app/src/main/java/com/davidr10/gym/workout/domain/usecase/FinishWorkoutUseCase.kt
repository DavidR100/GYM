package com.davidr10.gym.workout.domain.usecase

import com.davidr10.gym.core.domain.model.Workout
import com.davidr10.gym.core.domain.model.WorkoutLog
import com.davidr10.gym.workout.domain.repository.WorkoutRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.time.LocalDate
import java.util.UUID

class FinishWorkoutUseCase(private val repository: WorkoutRepository) {
    suspend operator fun invoke(routineId: Long, bodyWeight: Double, workout: Workout) {

        val workoutLog = WorkoutLog(
            id = null,
            bodyWeight = bodyWeight,
            date = LocalDate.now(),
            workout = workout
        )
          repository.saveWorkout(routineId, workoutLog)
    }
}
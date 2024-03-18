package com.davidr10.gym.workout.domain.repository

import com.davidr10.gym.core.domain.model.Workout

interface WorkoutRepository {
    suspend fun getNextWorkoutsByRoutine(routineId: String): List<Workout>
}
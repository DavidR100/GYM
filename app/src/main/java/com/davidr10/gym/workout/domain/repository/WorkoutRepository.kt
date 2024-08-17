package com.davidr10.gym.workout.domain.repository

import com.davidr10.gym.core.domain.model.Exercise
import com.davidr10.gym.core.domain.model.Routine
import com.davidr10.gym.core.domain.model.Workout
import com.davidr10.gym.core.domain.model.WorkoutLog

interface WorkoutRepository {
    suspend fun getAlltWorkoutsByRoutine(id: String): List<String>

    suspend fun getWorkoutById(id: String): Workout

    suspend fun getLastWorkoutLogInRoutine(routineId: String): String?
    suspend fun getLastWorkoutLogWorkout(workoutId: String): Workout?

}
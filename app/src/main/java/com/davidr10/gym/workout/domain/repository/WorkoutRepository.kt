package com.davidr10.gym.workout.domain.repository

import com.davidr10.gym.core.domain.model.Workout
import com.davidr10.gym.core.domain.model.WorkoutLog

interface WorkoutRepository {
    suspend fun getAlltWorkoutsIdByRoutine(id: Long): List<Long>

    suspend fun getWorkoutById(id: Long): Workout

    suspend fun getLastWorkoutLogInRoutine(routineId: Long): Long?
    suspend fun countAllWorkoutLogs(routineId: Long): Int
    suspend fun getLastWorkoutLogWorkout(workoutId: Long): Workout?
    suspend fun saveWorkout(routineId: Long, workoutLog: WorkoutLog)

}
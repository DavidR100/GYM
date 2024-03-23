package com.davidr10.gym.workout.data.repository

import com.davidr10.gym.core.data.local.dao.ExerciseDao
import com.davidr10.gym.core.data.local.dao.RoutineDao
import com.davidr10.gym.core.data.local.dao.WorkoutDao
import com.davidr10.gym.core.data.local.dao.WorkoutSetDao
import com.davidr10.gym.core.domain.model.Workout
import com.davidr10.gym.core.data.local.mapper.toDomain
import com.davidr10.gym.workout.domain.repository.WorkoutRepository

class WorkoutRepositoryImpl(
    private val routineDao: RoutineDao,
    private val workoutDao: WorkoutDao,
    private val exerciseDao: ExerciseDao,
    private val workoutSetDao: WorkoutSetDao
): WorkoutRepository {
    override suspend fun getAlltWorkoutsByRoutine(id: String): List<String> {
        return workoutDao.getWorkoutsByRoutineId(id)
    }

    override suspend fun getWorkoutById(id: String): Workout {
        return workoutDao.getWorkoutById(id).toDomain(listOf())
    }
}
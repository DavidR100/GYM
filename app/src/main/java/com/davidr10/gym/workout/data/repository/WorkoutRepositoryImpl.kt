package com.davidr10.gym.workout.data.repository

import androidx.compose.runtime.mutableStateOf
import com.davidr10.gym.core.data.local.dao.ExerciseDao
import com.davidr10.gym.core.data.local.dao.RoutineDao
import com.davidr10.gym.core.data.local.dao.WorkoutDao
import com.davidr10.gym.core.data.local.dao.WorkoutLogDao
import com.davidr10.gym.core.data.local.dao.WorkoutSetDao
import com.davidr10.gym.core.data.local.entities.ExerciseEntity
import com.davidr10.gym.core.data.local.entities.WorkoutSetEntity
import com.davidr10.gym.core.domain.model.Workout
import com.davidr10.gym.core.data.local.mapper.toDomain
import com.davidr10.gym.core.domain.model.Exercise
import com.davidr10.gym.core.domain.model.WorkoutLog
import com.davidr10.gym.workout.domain.repository.WorkoutRepository

class WorkoutRepositoryImpl(
    private val routineDao: RoutineDao,
    private val workoutDao: WorkoutDao,
    private val exerciseDao: ExerciseDao,
    private val workoutSetDao: WorkoutSetDao,
    private val workoutLogDao: WorkoutLogDao

) : WorkoutRepository {
    override suspend fun getAlltWorkoutsByRoutine(id: String): List<String> {
        return workoutDao.getWorkoutsByRoutineId(id)
    }

    override suspend fun getWorkoutById(id: String): Workout {
        val exercises = getExercisesForWorkout(id)
        return workoutDao.getWorkoutById(id).toDomain(exercises)
    }

    private suspend fun getExercisesForWorkout(workoutId: String): List<Exercise> {

        val exercises = exerciseDao.getExercisesIdsByWorkoutId(workoutId)
        val fullExercises = mutableListOf<Exercise>()
        exercises.forEach { exer ->
            val sets = workoutSetDao.getWorkoutSetsByExerciseId(exer)
            val exercises = exerciseDao.getExerciseById(exer)
            fullExercises.add(exercises.toDomain(sets.map { it.toDomain() }))
        }
        return fullExercises
    }

    override suspend fun getLastWorkoutLogInRoutine(routineId: String): String? {
        val workoutLog = workoutLogDao.getLastWorkoutLogInRoutine(routineId)
        return workoutLog?.workoutId
    }

    override suspend fun getLastWorkoutLogWorkout(workoutId: String): Workout? {
        val lastWorkout = workoutLogDao.getLastWorkout((workoutId))
        val workoutId = lastWorkout?.workoutId ?: return  null
        return getWorkoutById(workoutId)
    }
}
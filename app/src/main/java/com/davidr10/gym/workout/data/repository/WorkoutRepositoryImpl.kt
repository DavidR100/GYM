package com.davidr10.gym.workout.data.repository

import com.davidr10.gym.core.data.local.dao.ExerciseDao
import com.davidr10.gym.core.data.local.dao.RoutineDao
import com.davidr10.gym.core.data.local.dao.WorkoutDao
import com.davidr10.gym.core.data.local.dao.WorkoutLogDao
import com.davidr10.gym.core.data.local.dao.WorkoutSetDao
import com.davidr10.gym.core.domain.model.Workout
import com.davidr10.gym.core.data.mapper.toDomain
import com.davidr10.gym.core.data.mapper.toEntity
import com.davidr10.gym.core.domain.model.Exercise
import com.davidr10.gym.core.domain.model.WorkoutLog
import com.davidr10.gym.workout.domain.repository.WorkoutRepository
import java.util.UUID

class WorkoutRepositoryImpl(
    private val routineDao: RoutineDao,
    private val workoutDao: WorkoutDao,
    private val exerciseDao: ExerciseDao,
    private val workoutSetDao: WorkoutSetDao,
    private val workoutLogDao: WorkoutLogDao

) : WorkoutRepository {
    override suspend fun getAlltWorkoutsIdByRoutine(id: Long): List<Long> {
        return workoutDao.getWorkoutsByRoutineId(id)
    }

    override suspend fun getWorkoutById(id: Long): Workout {
        return workoutDao.getWorkoutById(id).toDomain()
    }

    override suspend fun getLastWorkoutLogInRoutine(routineId: Long): Long? {
        val workoutLog = workoutLogDao.getLastWorkoutLogInRoutine(routineId)
        return workoutLog?.workoutId
    }

    override suspend fun countAllWorkoutLogs(routineId: Long): Int {
        return workoutLogDao.countAllWorkoutLogs(routineId)
    }

    override suspend fun getLastWorkoutLogWorkout(workoutId: Long): Workout? {
        val lastWorkoutLog = workoutLogDao.getLastWorkout(workoutId)
        val lastWorkout = lastWorkoutLog?.workout ?: return null
        return lastWorkout.toDomain()
    }

    override suspend fun saveWorkout(routineId: Long, workoutLog: WorkoutLog) {
        val workout = workoutLog.workout.copy(id = null)
        val log = workoutLog.copy(workout = workout)
        workoutLogDao.createWorkoutLog(log.toEntity(routineId))
        val workoutId = workoutDao.insertWorkout(workout.toEntity(routineId))
        workout.exercises.forEach { exercise ->
            val exerciseId = exerciseDao.insertExercise(exercise.toEntity(workoutId))
            exercise.sets.forEach { set ->
                workoutSetDao.insertWorkoutSet(set.toEntity(exerciseId))
            }
        }
    }
}
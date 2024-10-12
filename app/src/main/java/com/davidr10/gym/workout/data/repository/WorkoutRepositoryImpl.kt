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
    override suspend fun getAlltWorkoutsIdByRoutine(id: String): List<String> {
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
            val exercise = exerciseDao.getExerciseById(exer)
            fullExercises.add(exercise.toDomain(sets.map { it.toDomain() }))
        }
        return fullExercises
    }

    override suspend fun getLastWorkoutLogInRoutine(routineId: String): String? {
        val workoutLog = workoutLogDao.getLastWorkoutLogInRoutine(routineId)
        return workoutLog?.workoutId
    }

    override suspend fun countAllWorkoutLogs(routineId: String): Int {
        return workoutLogDao.countAllWorkoutLogs(routineId)
    }

    override suspend fun getLastWorkoutLogWorkout(workoutId: String): Workout? {
        val lastWorkout = workoutLogDao.getLastWorkout((workoutId))
        val lastWorkoutId = lastWorkout?.workoutId ?: return null
        return getWorkoutById(lastWorkoutId)
    }

    override suspend fun saveWorkout(routineId: String, workoutLog: WorkoutLog) {
        val workout = workoutLog.workout.copy(id = UUID.randomUUID().toString())
        val log = workoutLog.copy(workout = workout)
        workoutLogDao.createWorkoutLog(workoutLog.toEntity(routineId))
        workoutDao.insertWorkout(workout.toEntity(routineId))
        workout.exercises.forEach { exercise ->
            val updateExercise =
                exercise.toEntity(workout.id).copy(exerciseId = UUID.randomUUID().toString())
            exerciseDao.insertExercise(updateExercise)
            exercise.sets.forEach { set ->
                val updateSet = set.toEntity(updateExercise.exerciseId).copy(
                    workuotSetId = null
                )
                workoutSetDao.insertWorkoutSet(updateSet)
            }
        }
    }
}
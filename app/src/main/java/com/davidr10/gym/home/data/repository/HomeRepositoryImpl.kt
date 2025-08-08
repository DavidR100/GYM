package com.davidr10.gym.home.data.repository

import com.davidr10.gym.core.data.extension.toTimeStamp
import com.davidr10.gym.core.data.extension.toZonedDateTime
import com.davidr10.gym.core.data.local.dao.ExerciseDao
import com.davidr10.gym.core.data.local.dao.RoutineDao
import com.davidr10.gym.core.data.local.dao.WorkoutDao
import com.davidr10.gym.core.data.local.dao.WorkoutLogDao
import com.davidr10.gym.core.data.local.dao.WorkoutSetDao
import com.davidr10.gym.core.domain.model.Routine
import com.davidr10.gym.core.data.mapper.toDomain
import com.davidr10.gym.core.data.mapper.toEntity
import com.davidr10.gym.core.domain.model.WorkoutLog
import com.davidr10.gym.home.domain.repository.HomeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.time.LocalDate
import java.time.LocalTime
import java.time.ZoneId
import java.time.ZonedDateTime

class HomeRepositoryImpl(
    private val routineDao: RoutineDao,
    private val workoutDao: WorkoutDao,
    private val exerciseDao: ExerciseDao,
    private val workoutSetDao: WorkoutSetDao,
    private val workoutLogDao: WorkoutLogDao
) : HomeRepository {
    override fun getAllRoutine(): Flow<List<Routine>> {
        return routineDao.getAllRoutines().map { it.map { it.toDomain() } }
    }

    override suspend fun insertRoutine(routine: Routine) {
        val routineId = routineDao.insertRoutine(routine = routine.toEntity())
        routine.workouts.forEach { workout ->
            val workoutId = workoutDao.insertWorkout(workout.toEntity(routineId))
            workout.exercises.forEach { exercise ->
                val exerciseId = exerciseDao.insertExercise(exercise.toEntity(workoutId))
                exercise.sets.forEach { set ->
                    workoutSetDao.insertWorkoutSet(set.toEntity(exerciseId))
                }
            }
        }
    }

    override suspend fun getAllWeightsInLastWeek(): List<Double> {
        val today = ZonedDateTime.of(LocalDate.now(), LocalTime.of(23, 59), ZoneId.systemDefault())
        val lastWeek = today.minusDays(8)
        val weights = workoutLogDao.getLastWeekWorkoutLogs(
            today = today.toTimeStamp(),
            lastWeek = lastWeek.toTimeStamp()
        )
            .map {
                it.bodyWeight
            }

        return weights
    }
}
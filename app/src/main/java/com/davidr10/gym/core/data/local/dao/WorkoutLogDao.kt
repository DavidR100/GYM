package com.davidr10.gym.core.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.davidr10.gym.core.data.local.entities.RoutineEntity
import com.davidr10.gym.core.data.local.entities.WorkoutEntity
import com.davidr10.gym.core.data.local.entities.WorkoutLogEntity
import com.davidr10.gym.core.data.local.entities.relation.WorkoutLogWithWorkout
import com.davidr10.gym.core.domain.model.Workout
import kotlinx.coroutines.flow.Flow
import java.time.LocalDate

@Dao
interface WorkoutLogDao {

    @Query("Select * From WorkoutLogEntity WHERE workoutLogId = :workoutLogId")
    suspend fun getWorkoutLogById(workoutLogId: Long): WorkoutLogEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun createWorkoutLog(entity: WorkoutLogEntity): Long

    @Query("Select * From WorkoutLogEntity WHERE routineId = :id ORDER BY date DESC LIMIT 1")
    suspend fun getLastWorkoutLogInRoutine(id: Long): WorkoutLogEntity?

    @Transaction
    @Query("Select * From WorkoutLogEntity WHERE routineId = :id ORDER BY date DESC LIMIT 1")
    suspend fun getLastWorkout(id: Long): WorkoutLogWithWorkout?

    @Delete
    suspend fun deleteWorkoutLogById(entity: WorkoutLogEntity)

    @Query("Select Count(workoutLogId) From WorkoutLogEntity WHERE routineId = :id")
    suspend fun countAllWorkoutLogs(id: Long): Int

    @Query("Select * From WorkoutLogEntity WHERE date BETWEEN :lastWeek AND :today")
    suspend fun getLastWeekWorkoutLogs(today: Long, lastWeek: Long): List<WorkoutLogEntity>
}
package com.davidr10.gym.core.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.davidr10.gym.core.data.local.entities.RoutineEntity
import com.davidr10.gym.core.data.local.entities.WorkoutEntity
import com.davidr10.gym.core.data.local.entities.WorkoutLogEntity
import com.davidr10.gym.core.domain.model.Workout
import kotlinx.coroutines.flow.Flow

@Dao
interface WorkoutLogDao {

    @Query("Select * From WorkoutLogEntity WHERE workoutLogId = :workoutLogId")
    suspend fun getWorkoutLogById(workoutLogId: String): WorkoutLogEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun createWorkoutLog(entity: WorkoutLogEntity)

    @Query("Select * From WorkoutLogEntity WHERE routineId = :id ORDER BY date DESC LIMIT 1")
    suspend fun getLastWorkoutLogInRoutine(id: String): WorkoutLogEntity?

    @Query("Select * From WorkoutLogEntity WHERE routineId = :id ORDER BY date DESC LIMIT 1")
    suspend fun getLastWorkout(id: String): WorkoutLogEntity?

    @Delete
    suspend fun deleteWorkoutLogById(entity: WorkoutLogEntity)

    @Query("Select Count(workoutLogId) From WorkoutLogEntity WHERE routineId = :id")
    suspend fun countAllWorkoutLogs(id: String): Int
}
package com.davidr10.gym.core.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.davidr10.gym.core.data.local.entities.RoutineEntity
import com.davidr10.gym.core.data.local.entities.WorkoutEntity
import com.davidr10.gym.core.data.local.entities.relation.WorkoutWithExercises
import com.davidr10.gym.core.domain.model.Workout
import kotlinx.coroutines.flow.Flow

@Dao
interface WorkoutDao {

    @Transaction
    @Query("Select * From WorkoutEntity WHERE workoutId = :routineId")
    suspend fun getWorkoutById(routineId: String): WorkoutWithExercises

    @Query("Select workoutId From WorkoutEntity WHERE routineId = :routineId ORDER BY creationTime ASC")
    suspend fun getWorkoutsByRoutineId(routineId: String): List<String>
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWorkout(workoutEntity: WorkoutEntity)
}
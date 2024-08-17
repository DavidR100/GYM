package com.davidr10.gym.core.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.davidr10.gym.core.data.local.entities.RoutineEntity
import com.davidr10.gym.core.data.local.entities.WorkoutEntity
import com.davidr10.gym.core.data.local.entities.WorkoutSetEntity
import com.davidr10.gym.core.domain.model.Workout
import kotlinx.coroutines.flow.Flow

@Dao
interface WorkoutSetDao {

    @Query("Select * From WorkoutSetEntity WHERE exerciseId = :exerciseId")
    suspend fun getWorkoutSetsByExerciseId(exerciseId: String): List<WorkoutSetEntity>
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWorkoutSet(set: WorkoutSetEntity)
}
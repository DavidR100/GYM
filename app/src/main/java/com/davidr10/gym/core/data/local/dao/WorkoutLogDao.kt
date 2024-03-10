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

    @Query("Select * From WorkoutLogEntity WHERE id = :id")
    fun getWorkoutLogById(id: String): WorkoutLogEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun createWorkoutLogById(entity: WorkoutLogEntity)

    @Delete
    fun deleteWorkoutLogById(entity: WorkoutLogEntity)
}
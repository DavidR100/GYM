package com.davidr10.gym.core.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.davidr10.gym.core.data.local.entities.RoutineEntity
import com.davidr10.gym.core.data.local.entities.relation.RoutineWithWorkouts
import com.davidr10.gym.core.domain.model.Routine
import kotlinx.coroutines.flow.Flow

@Dao
interface RoutineDao {

    @Transaction
    @Query("Select * From RoutineEntity")
    fun getAllRoutines(): Flow<List<RoutineWithWorkouts>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRoutine(routine: RoutineEntity): Long
}
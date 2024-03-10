package com.davidr10.gym.core.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.davidr10.gym.core.data.local.entities.RoutineEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface RoutineDao {

    @Query("Select * From RoutineEntity")
    fun getAllRoutines(): Flow<List<RoutineEntity>>
}
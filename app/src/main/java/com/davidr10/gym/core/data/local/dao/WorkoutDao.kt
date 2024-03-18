package com.davidr10.gym.core.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.davidr10.gym.core.data.local.entities.RoutineEntity
import com.davidr10.gym.core.data.local.entities.WorkoutEntity
import com.davidr10.gym.core.domain.model.Workout
import kotlinx.coroutines.flow.Flow

@Dao
interface WorkoutDao {

    @Query("Select * From WorkoutEntity WHERE workuotId = :workuotId")
    fun getWorkoutById(workuotId: String): WorkoutEntity
}
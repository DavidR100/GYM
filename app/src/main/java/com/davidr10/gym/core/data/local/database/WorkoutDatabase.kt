package com.davidr10.gym.core.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.davidr10.gym.core.data.local.dao.RoutineDao
import com.davidr10.gym.core.data.local.dao.WorkoutDao
import com.davidr10.gym.core.data.local.dao.WorkoutLogDao
import com.davidr10.gym.core.data.local.entities.RoutineEntity
import com.davidr10.gym.core.data.local.entities.WorkoutEntity
import com.davidr10.gym.core.data.local.entities.WorkoutLogEntity

@Database(entities = [RoutineEntity::class, WorkoutEntity::class, WorkoutLogEntity::class],
    version = 1)
abstract class WorkoutDatabase: RoomDatabase() {
    abstract val routineDao: RoutineDao
    abstract val workoutDao: WorkoutDao
    abstract val workoutLogDao: WorkoutLogDao
}
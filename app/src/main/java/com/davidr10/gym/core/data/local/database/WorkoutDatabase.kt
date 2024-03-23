package com.davidr10.gym.core.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.davidr10.gym.core.data.local.dao.ExerciseDao
import com.davidr10.gym.core.data.local.dao.RoutineDao
import com.davidr10.gym.core.data.local.dao.WorkoutDao
import com.davidr10.gym.core.data.local.dao.WorkoutLogDao
import com.davidr10.gym.core.data.local.dao.WorkoutSetDao
import com.davidr10.gym.core.data.local.entities.ExerciseEntity
import com.davidr10.gym.core.data.local.entities.RoutineEntity
import com.davidr10.gym.core.data.local.entities.WorkoutEntity
import com.davidr10.gym.core.data.local.entities.WorkoutLogEntity
import com.davidr10.gym.core.data.local.entities.WorkoutSetEntity

@Database(entities = [RoutineEntity::class, WorkoutEntity::class, WorkoutLogEntity::class, ExerciseEntity::class, WorkoutSetEntity::class],
    version = 1)
abstract class WorkoutDatabase: RoomDatabase() {
    abstract val routineDao: RoutineDao
    abstract val workoutDao: WorkoutDao
    abstract val workoutsetDao: WorkoutSetDao
    abstract val exerciseDao: ExerciseDao
    abstract val workoutLogDao: WorkoutLogDao
}
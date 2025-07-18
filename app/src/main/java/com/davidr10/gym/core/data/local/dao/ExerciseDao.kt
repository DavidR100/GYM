package com.davidr10.gym.core.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.davidr10.gym.core.data.local.entities.ExerciseEntity
import com.davidr10.gym.core.data.local.entities.RoutineEntity
import com.davidr10.gym.core.data.local.entities.WorkoutEntity
import com.davidr10.gym.core.data.local.entities.WorkoutSetEntity
import com.davidr10.gym.core.data.local.entities.relation.ExerciseWithSets
import com.davidr10.gym.core.domain.model.Workout
import kotlinx.coroutines.flow.Flow

@Dao
interface ExerciseDao {

    @Transaction
    @Query("Select * From ExerciseEntity WHERE workoutId = :workoutId")
    suspend fun getExercisesByWorkoutId(workoutId: Long): List<ExerciseWithSets>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertExercise(exercise: ExerciseEntity): Long

    @Query("Select exerciseId From ExerciseEntity WHERE workoutId = :id")
    suspend fun getExercisesIdsByWorkoutId(id: Long): List<Int>

    @Transaction
    @Query("Select * From ExerciseEntity WHERE exerciseId = :id")
    suspend fun getExerciseById(id: Long): ExerciseWithSets
}
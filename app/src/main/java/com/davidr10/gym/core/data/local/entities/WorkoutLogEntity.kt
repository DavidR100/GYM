package com.davidr10.gym.core.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.davidr10.gym.core.domain.model.Exercise
import com.davidr10.gym.core.domain.model.Workout
import java.time.LocalDate

@Entity
data class WorkoutLogEntity(
    @PrimaryKey(autoGenerate = true)
    val workoutLogId: Long = 0,
    val bodyWeight: Double,
    val date: Long,
    val workoutId: Long,
    val routineId: Long
)

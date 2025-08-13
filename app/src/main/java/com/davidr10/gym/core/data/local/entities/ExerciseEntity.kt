package com.davidr10.gym.core.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.davidr10.gym.core.domain.model.Workout

@Entity
data class ExerciseEntity(
    @PrimaryKey(autoGenerate = true)
    val exerciseId: Long = 0,
    val name: String,
    val workoutId: Long
)

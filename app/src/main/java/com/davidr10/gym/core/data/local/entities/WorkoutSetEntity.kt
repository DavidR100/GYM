package com.davidr10.gym.core.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.davidr10.gym.core.domain.model.Exercise
import com.davidr10.gym.core.domain.model.Workout

@Entity
data class WorkoutSetEntity(
    @PrimaryKey(autoGenerate = true)
    val workuotSetId: Int? = null,
    val weight: Double,
    val repetitions: Int,
    val exerciseId: String
)

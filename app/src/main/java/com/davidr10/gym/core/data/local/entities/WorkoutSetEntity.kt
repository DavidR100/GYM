package com.davidr10.gym.core.data.local.entities

import android.util.Log
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.davidr10.gym.core.domain.model.Exercise
import com.davidr10.gym.core.domain.model.Workout

@Entity
data class WorkoutSetEntity(
    @PrimaryKey(autoGenerate = true)
    val workuotSetId: Long = 0,
    val weight: Double,
    val repetitions: Int,
    val exerciseId: Long
)

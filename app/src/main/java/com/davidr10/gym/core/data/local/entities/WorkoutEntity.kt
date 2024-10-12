package com.davidr10.gym.core.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.davidr10.gym.core.domain.model.Exercise
import com.davidr10.gym.core.domain.model.Workout

@Entity
data class WorkoutEntity(
    @PrimaryKey(autoGenerate = false)
    val workuotId: String,
    val name: String,
    val routineId: String,
    val creationTime: Long
    //val exercises: List<Exercise> //TODO: Relacionar tablas
)

package com.davidr10.gym.core.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.davidr10.gym.core.domain.model.Workout

@Entity
data class RoutineEntity(
    @PrimaryKey(autoGenerate = false)
    val id: String,
    val name: String,
    //val workout: List<Workout> //TODO: Relacionar tablas
)

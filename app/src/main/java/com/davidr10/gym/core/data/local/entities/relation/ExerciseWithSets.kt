package com.davidr10.gym.core.data.local.entities.relation

import androidx.room.Embedded
import androidx.room.Relation
import com.davidr10.gym.core.data.local.entities.ExerciseEntity
import com.davidr10.gym.core.data.local.entities.WorkoutSetEntity

data class ExerciseWithSets(
    @Embedded val exercise: ExerciseEntity,
    @Relation(
        parentColumn = "exerciseId",
        entityColumn = "exerciseId"
    )
    val sets: List<WorkoutSetEntity>
)

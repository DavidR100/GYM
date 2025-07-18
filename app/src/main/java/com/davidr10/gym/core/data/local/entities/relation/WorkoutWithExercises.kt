package com.davidr10.gym.core.data.local.entities.relation

import androidx.room.Embedded
import androidx.room.Relation
import com.davidr10.gym.core.data.local.entities.ExerciseEntity
import com.davidr10.gym.core.data.local.entities.WorkoutEntity
import com.davidr10.gym.core.data.local.entities.WorkoutSetEntity

data class WorkoutWithExercises(
    @Embedded val workoutEntity: WorkoutEntity,
    @Relation(
        parentColumn = "workuotId",
        entityColumn = "workoutId",
        entity = ExerciseEntity::class
    )
    val exercises: List<ExerciseWithSets>
)

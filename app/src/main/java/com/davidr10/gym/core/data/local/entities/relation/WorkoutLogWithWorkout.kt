package com.davidr10.gym.core.data.local.entities.relation

import androidx.room.Embedded
import androidx.room.Relation
import com.davidr10.gym.core.data.local.entities.WorkoutEntity
import com.davidr10.gym.core.data.local.entities.WorkoutLogEntity

data class WorkoutLogWithWorkout(
    @Embedded val workoutLogEntity: WorkoutLogEntity,
    @Relation(
        parentColumn = "workoutId",
        entityColumn = "workoutId",
        entity = WorkoutEntity::class
    )
    val workout: WorkoutWithExercises
)

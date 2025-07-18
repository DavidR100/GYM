package com.davidr10.gym.core.data.local.entities.relation

import androidx.room.Embedded
import androidx.room.Relation
import com.davidr10.gym.core.data.local.entities.ExerciseEntity
import com.davidr10.gym.core.data.local.entities.RoutineEntity
import com.davidr10.gym.core.data.local.entities.WorkoutEntity
import com.davidr10.gym.core.data.local.entities.WorkoutSetEntity

data class RoutineWithWorkouts(
    @Embedded val routineEntity: RoutineEntity,
    @Relation(
        parentColumn = "routineId",
        entityColumn = "routineId",
        entity = WorkoutEntity::class
    )
    val workouts: List<WorkoutWithExercises>
)

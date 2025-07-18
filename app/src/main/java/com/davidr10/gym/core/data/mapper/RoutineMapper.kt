package com.davidr10.gym.core.data.mapper

import com.davidr10.gym.core.data.local.entities.RoutineEntity
import com.davidr10.gym.core.data.local.entities.relation.RoutineWithWorkouts
import com.davidr10.gym.core.domain.model.Routine

fun RoutineEntity.toDomain(): Routine {
    return Routine(
        id = this.routineId,
        name = this.name,
        workouts = emptyList()
    )
}

fun RoutineWithWorkouts.toDomain(): Routine {
    return Routine(
        id = routineEntity.routineId,
        name = routineEntity.name,
        workouts = workouts.map { it.toDomain() }
    )
}

fun Routine.toEntity(): RoutineEntity {
    return RoutineEntity(
        routineId = id,
        name = name
    )
}
package com.davidr10.gym.core.data.local.mapper

import com.davidr10.gym.core.data.local.entities.RoutineEntity
import com.davidr10.gym.core.domain.model.Routine

fun RoutineEntity.toDomain(): Routine{
    return Routine(
        id = this.routineId,
        name = this.name,
        workouts = emptyList()
    )
}
fun Routine.toEntity(): RoutineEntity{
    return RoutineEntity(
         routineId = id,
        name = name
    )
}
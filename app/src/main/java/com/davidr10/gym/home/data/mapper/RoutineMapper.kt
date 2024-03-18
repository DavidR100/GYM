package com.davidr10.gym.home.data.mapper

import com.davidr10.gym.core.data.local.entities.RoutineEntity
import com.davidr10.gym.core.domain.model.Routine

fun RoutineEntity.toDomain(): Routine{
    return Routine(
        id = this.routineId,
        name = this.name,
        workouts = emptyList()
    )
}
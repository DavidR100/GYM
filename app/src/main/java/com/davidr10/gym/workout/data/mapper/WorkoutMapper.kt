package com.davidr10.gym.workout.data.mapper

import com.davidr10.gym.core.data.local.entities.ExerciseEntity
import com.davidr10.gym.core.data.local.entities.WorkoutEntity
import com.davidr10.gym.core.data.local.entities.WorkoutSetEntity
import com.davidr10.gym.core.domain.model.Exercise
import com.davidr10.gym.core.domain.model.Workout
import com.davidr10.gym.core.domain.model.WorkoutSet

fun WorkoutEntity.toDomain(exercise: List<Exercise>):Workout {
    return Workout(
        id = workuotId,
        name = name,
        exercises = exercise
    )
}

fun ExerciseEntity.toDomain(sets: List<WorkoutSet>): Exercise {
    return Exercise(
        id = exerciseId,
        name = name,
        sets = sets
    )
}

fun WorkoutSetEntity.toDomain(): WorkoutSet {
    return WorkoutSet(
        weight = weight,
        repetitions = repetitions
    )
}
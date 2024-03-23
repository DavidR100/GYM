package com.davidr10.gym.core.data.local.mapper

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
        id = workuotSetId!!,
        weight = weight,
        repetitions = repetitions
    )
}
fun Workout.toEntity(routineId: String):WorkoutEntity {
    return WorkoutEntity(
        workuotId = id,
        name = name,
        routineId = routineId
    )
}

fun Exercise.toEntity(workoutId: String): ExerciseEntity {
    return ExerciseEntity(
        exerciseId = id,
        name = name,
        workoutId = workoutId
    )
}

fun WorkoutSet.toEntity(exerciseId: String): WorkoutSetEntity {
    return WorkoutSetEntity(
        workuotSetId = id,
        weight = weight,
        repetitions = repetitions,
        exerciseId = exerciseId
    )
}
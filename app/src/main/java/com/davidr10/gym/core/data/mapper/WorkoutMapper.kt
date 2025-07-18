package com.davidr10.gym.core.data.mapper

import com.davidr10.gym.core.data.extension.toTimeStamp
import com.davidr10.gym.core.data.extension.toZonedDateTime
import com.davidr10.gym.core.data.local.entities.ExerciseEntity
import com.davidr10.gym.core.data.local.entities.WorkoutEntity
import com.davidr10.gym.core.data.local.entities.WorkoutLogEntity
import com.davidr10.gym.core.data.local.entities.WorkoutSetEntity
import com.davidr10.gym.core.data.local.entities.relation.ExerciseWithSets
import com.davidr10.gym.core.data.local.entities.relation.WorkoutWithExercises
import com.davidr10.gym.core.domain.model.Exercise
import com.davidr10.gym.core.domain.model.Workout
import com.davidr10.gym.core.domain.model.WorkoutLog
import com.davidr10.gym.core.domain.model.WorkoutSet
import java.time.LocalDateTime

fun WorkoutEntity.toDomain(exercise: List<Exercise>): Workout {
    return Workout(
        id = workoutId,
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

fun Workout.toEntity(routineId: String): WorkoutEntity {
    return WorkoutEntity(
        workoutId = id,
        name = name,
        routineId = routineId,
        creationTime = LocalDateTime.now().toZonedDateTime().toTimeStamp()
    )
}

fun Exercise.toEntity(workoutId: String): ExerciseEntity {
    return ExerciseEntity(
        exerciseId = id,
        name = name,
        workoutId = workoutId
    )
}

fun WorkoutSet.toEntity(exerciseId: Long): WorkoutSetEntity {
    return WorkoutSetEntity(
        workuotSetId = id,
        weight = weight,
        repetitions = repetitions,
        exerciseId = exerciseId
    )
}

fun WorkoutLog.toEntity(routineId: String): WorkoutLogEntity {
    return WorkoutLogEntity(
        workoutLogId = this.id,
        bodyWeight = this.bodyWeight,
        date = this.date.toTimeStamp(),
        workoutId = this.workout.id,
        routineId = routineId
    )
}

fun ExerciseWithSets.toDomain(): Exercise {
    return Exercise(
        id = exercise.exerciseId,
        name = exercise.name,
        sets = sets.map { it.toDomain() }

    )
}

fun WorkoutWithExercises.toDomain(): Workout {
    return Workout(
        id = workoutEntity.workoutId,
        name = workoutEntity.name,
        exercises = exercises.map { it.toDomain() }
    )
}
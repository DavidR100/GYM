package com.davidr10.gym.core.data.local.database

import com.davidr10.gym.core.data.local.entities.ExerciseEntity
import com.davidr10.gym.core.data.local.entities.RoutineEntity
import com.davidr10.gym.core.data.local.entities.WorkoutEntity
import com.davidr10.gym.core.data.local.entities.WorkoutSetEntity
import com.davidr10.gym.core.domain.model.Exercise
import com.davidr10.gym.core.domain.model.Routine
import com.davidr10.gym.core.domain.model.Workout
import com.davidr10.gym.core.domain.model.WorkoutSet
import java.util.UUID

object FakeDataBase {
    val fakeRoutine = RoutineEntity("routine1","3x Workout")

    val fakeWorkoutA = WorkoutEntity("workouta", "Workout A", "routine1")
    val fakeExercise1 = ExerciseEntity("ex1", "Bench Press", "workouta")
    val fakeSets1 = WorkoutSetEntity(null, 10.0, 5, "ex1")
    val fakeSets2 = WorkoutSetEntity(null, 10.0, 5, "ex1")
    val fakeSets3 = WorkoutSetEntity(null, 5.0, 8, "ex1")

    val fakeExercise2 = ExerciseEntity("ex2", "Deadlift", "workouta")
    val fakeSets4 = WorkoutSetEntity(null, 10.0, 5, "ex2")
    val fakeSets5 = WorkoutSetEntity(null, 5.0, 8, "ex2")

    val fakeWorkoutB = WorkoutEntity("workoutb", "Workout B", "routine1")

    val fakeExercise3 = ExerciseEntity("ex3", "Squats", "workoutb")
    val fakeSets6 = WorkoutSetEntity(null, 10.0, 5, "ex3")
    val fakeSets7 = WorkoutSetEntity(null, 5.0, 8, "ex3")

    val fakeExercise4 = ExerciseEntity("ex4", "Bench Press", "workoutb")
    val fakeSets8 = WorkoutSetEntity(null, 10.0, 5, "ex4")
    val fakeSets9 = WorkoutSetEntity(null, 5.0, 8, "ex14")
}
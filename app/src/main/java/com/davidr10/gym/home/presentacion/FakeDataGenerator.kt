package com.davidr10.gym.home.presentacion

import com.davidr10.gym.core.domain.model.Exercise
import com.davidr10.gym.core.domain.model.Routine
import com.davidr10.gym.core.domain.model.Workout
import com.davidr10.gym.core.domain.model.WorkoutSet
import java.util.UUID

object FakeDataGenerator {
    fun createRoutine(): Routine {
        return Routine(
            id = UUID.randomUUID().toString(),
            name = "Full Body Workout",
            workouts = listOf(createWorkoutA(), createWorkoutB() )
        )
    }

    fun createWorkoutA(): Workout {
        return Workout(
            id = UUID.randomUUID().toString(),
            name = "Workout A",
            createExercisesA()
        )
    }

    fun createWorkoutB(): Workout {
        return Workout(
            id = UUID.randomUUID().toString(),
            name = "Workout B",
            createExercisesB()
        )
    }

    private fun createExercisesA(): List<Exercise> {
        val compoundSets = listOf(
            WorkoutSet(
                id = null,
                weight = 0.0,
                repetitions = 5
            ),
            WorkoutSet(
                id = null,
                weight = 0.0,
                repetitions = 6
            ),
            WorkoutSet(
                id = null,
                weight = 0.0,
                repetitions = 8
            )
        )
        val isolatedSets = listOf(
            WorkoutSet(
                id = null,
                weight = 0.0,
                repetitions = 12
            ),
            WorkoutSet(
                id = null,
                weight = 0.0,
                repetitions = 12
            )
        )

        val exercisesA = listOf(
            Exercise(
                id = UUID.randomUUID().toString(),
                "Squats",
                sets = compoundSets
            ),
            Exercise(
                id = UUID.randomUUID().toString(),
                "Bench Press",
                sets = compoundSets
            ),
            Exercise(
                id = UUID.randomUUID().toString(),
                "Wighted Chinup",
                sets = compoundSets
            ),
            Exercise(
                id = UUID.randomUUID().toString(),
                "Machine Lateral Raises",
                sets = isolatedSets
            ),
            Exercise(
                id = UUID.randomUUID().toString(),
                "Diverging Low Row",
                sets = isolatedSets
            ),
            Exercise(
                id = UUID.randomUUID().toString(),
                "Tricep Pushdowns",
                sets = isolatedSets
            ),
            Exercise(
                id = UUID.randomUUID().toString(),
                "MIncline Dumbbell Bicep Curl",
                sets = isolatedSets
            )
        )

        return  exercisesA
    }

    private fun createExercisesB(): List<Exercise> {
        val compoundSets = listOf(
            WorkoutSet(
                id = null,
                weight = 0.0,
                repetitions = 5
            ),
            WorkoutSet(
                id = null,
                weight = 0.0,
                repetitions = 6
            ),
            WorkoutSet(
                id = null,
                weight = 0.0,
                repetitions = 8
            )
        )

        val isolatedSets = listOf(
            WorkoutSet(
                id = null,
                weight = 0.0,
                repetitions = 12
            ),
            WorkoutSet(
                id = null,
                weight = 0.0,
                repetitions = 12
            )
        )

        val shrugsSets = listOf(
            WorkoutSet(
                id = null,
                weight = 0.0,
                repetitions = 12
            ),
            WorkoutSet(
                id = null,
                weight = 0.0,
                repetitions = 12
            ),
            WorkoutSet(
                id = null,
                weight = 0.0,
                repetitions = 12
            )
        )

        val exercisesB = listOf(
            Exercise(
                id = UUID.randomUUID().toString(),
                "Squats",
                sets = compoundSets
            ),
            Exercise(
                id = UUID.randomUUID().toString(),
                "Overhead Press",
                sets = compoundSets
            ),
            Exercise(
                id = UUID.randomUUID().toString(),
                "Wighted Chinup",
                sets = compoundSets
            ),
            Exercise(
                id = UUID.randomUUID().toString(),
                "Dumbell Shrugs",
                sets = shrugsSets
            ),
            Exercise(
                id = UUID.randomUUID().toString(),
                "Pec Dec",
                sets = isolatedSets
            ),
            Exercise(
                id = UUID.randomUUID().toString(),
                "Tricep Pushdowns",
                sets = isolatedSets
            ),
            Exercise(
                id = UUID.randomUUID().toString(),
                "MIncline Dumbbell Bicep Curl",
                sets = isolatedSets
            )
        )

        return  exercisesB
    }

}
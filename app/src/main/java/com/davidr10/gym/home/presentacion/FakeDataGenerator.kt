package com.davidr10.gym.home.presentacion

import com.davidr10.gym.core.domain.model.Exercise
import com.davidr10.gym.core.domain.model.Routine
import com.davidr10.gym.core.domain.model.Workout
import com.davidr10.gym.core.domain.model.WorkoutSet
import java.util.UUID

object FakeDataGenerator {
    fun createRoutine(): Routine {
        return Routine(
            id = null,
            name = "Full Body Workout",
            workouts = listOf(createWorkoutA(), createWorkoutB())
        )
    }

    fun createWorkoutA(): Workout {
        return Workout(
            id = null,
            name = "Workout A",
            createExercisesA()
        )
    }

    fun createWorkoutB(): Workout {
        return Workout(
            id = null,
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
                name = "Squats",
                sets = compoundSets
            ),
            Exercise(
                name = "Bench Press",
                sets = compoundSets
            ),
            Exercise(
                name = "Wighted Chinup",
                sets = compoundSets
            ),
            Exercise(
                name = "Machine Lateral Raises",
                sets = isolatedSets
            ),
            Exercise(
                name = "Diverging Low Row",
                sets = isolatedSets
            ),
            Exercise(
                name = "Tricep Pushdowns",
                sets = isolatedSets
            ),
            Exercise(
                name = "Incline Dumbbell Bicep Curl",
                sets = isolatedSets
            )
        )

        return exercisesA
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
                name = "Squats",
                sets = compoundSets
            ),
            Exercise(
                name = "Overhead Press",
                sets = compoundSets
            ),
            Exercise(
                name = "Wighted Chinup",
                sets = compoundSets
            ),
            Exercise(
                name = "Dumbell Shrugs",
                sets = shrugsSets
            ),
            Exercise(
                name = "Pec Dec",
                sets = isolatedSets
            ),
            Exercise(
                name = "Tricep Pushdowns",
                sets = isolatedSets
            ),
            Exercise(
                name = "Incline Dumbbell Bicep Curl",
                sets = isolatedSets
            )
        )

        return exercisesB
    }

}
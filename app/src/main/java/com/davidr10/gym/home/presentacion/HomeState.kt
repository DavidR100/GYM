package com.davidr10.gym.home.presentacion

import androidx.compose.ui.Modifier
import com.davidr10.gym.core.domain.model.Exercise
import com.davidr10.gym.core.domain.model.Routine
import com.davidr10.gym.core.domain.model.Workout
import com.davidr10.gym.core.domain.model.WorkoutSet
import java.util.UUID

data class HomeState(
    val routine: List<Routine> = listOf(fakeRoutine)
)

val fakeRoutine = Routine(
    id = UUID.randomUUID().toString(),
    name = "3X Workout",
    workouts = listOf(
        Workout(
            id = UUID.randomUUID().toString(),
                name = "Benchpress",
            exercises = listOf(
                Exercise(
                    name = "Workout A",
                    listOf(
                        WorkoutSet(
                            weight = 30.5,
                            repetitions = 5
                        ),
                        WorkoutSet(
                            weight = 26.5,
                            repetitions = 6
                        ),
                        WorkoutSet(
                            weight = 22.5,
                            repetitions = 8
                        )
                    )
                )
            )
        ),
        Workout(
            id = UUID.randomUUID().toString(),
            name = "Workout B",
            exercises = listOf(
                Exercise(
                    name = "Squats",
                    listOf(
                        WorkoutSet(
                            weight = 30.5,
                            repetitions = 5
                        ),
                        WorkoutSet(
                            weight = 26.5,
                            repetitions = 6
                        ),
                        WorkoutSet(
                            weight = 22.5,
                            repetitions = 8
                        )
                    )
                )
            )
        )
    )
)
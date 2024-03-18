package com.davidr10.gym.home.presentacion

import androidx.compose.ui.Modifier
import com.davidr10.gym.core.domain.model.Exercise
import com.davidr10.gym.core.domain.model.Routine
import com.davidr10.gym.core.domain.model.Workout
import com.davidr10.gym.core.domain.model.WorkoutSet
import java.util.UUID

data class HomeState(
    val routine: List<Routine> = listOf()
)

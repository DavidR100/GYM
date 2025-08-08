package com.davidr10.gym.home.domain.repository

import com.davidr10.gym.core.domain.model.Routine
import com.davidr10.gym.core.domain.model.WorkoutLog
import kotlinx.coroutines.flow.Flow

interface HomeRepository {
    fun getAllRoutine(): Flow<List<Routine>>
    suspend fun insertRoutine(routine: Routine)
    suspend fun getAllWeightsInLastWeek(): List<Double>
}
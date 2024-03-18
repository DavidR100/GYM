package com.davidr10.gym.home.domain.repository

import com.davidr10.gym.core.domain.model.Routine
import kotlinx.coroutines.flow.Flow

interface HomeRepository {
    fun getAllRoutine(): Flow<List<Routine>>
}
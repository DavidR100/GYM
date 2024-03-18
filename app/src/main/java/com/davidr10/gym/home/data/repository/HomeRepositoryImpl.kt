package com.davidr10.gym.home.data.repository

import com.davidr10.gym.core.data.local.database.FakeDataBase
import com.davidr10.gym.core.domain.model.Exercise
import com.davidr10.gym.core.domain.model.Routine
import com.davidr10.gym.core.domain.model.Workout
import com.davidr10.gym.core.domain.model.WorkoutSet
import com.davidr10.gym.home.data.mapper.toDomain
import com.davidr10.gym.home.domain.repository.HomeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import java.util.UUID

class HomeRepositoryImpl: HomeRepository {
    override fun getAllRoutine(): Flow<List<Routine>> {
        val routine = FakeDataBase.fakeRoutine.toDomain()
        return flowOf(
            listOf(routine)
        )
    }
}
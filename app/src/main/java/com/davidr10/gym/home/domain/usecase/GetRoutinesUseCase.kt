package com.davidr10.gym.home.domain.usecase

import com.davidr10.gym.core.domain.model.Routine
import com.davidr10.gym.home.domain.repository.HomeRepository
import kotlinx.coroutines.flow.Flow

class GetRoutinesUseCase(private val repository: HomeRepository) {

    operator fun invoke(): Flow<List<Routine>>{
        return repository.getAllRoutine()
    }
}
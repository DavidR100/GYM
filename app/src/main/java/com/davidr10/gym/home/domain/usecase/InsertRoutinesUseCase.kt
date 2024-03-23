package com.davidr10.gym.home.domain.usecase

import com.davidr10.gym.core.domain.model.Routine
import com.davidr10.gym.home.domain.repository.HomeRepository
import kotlinx.coroutines.flow.Flow

class InsertRoutinesUseCase(private val repository: HomeRepository) {

    suspend operator fun invoke(routine: Routine) {
        return repository.insertRoutine(routine = routine)
    }
}
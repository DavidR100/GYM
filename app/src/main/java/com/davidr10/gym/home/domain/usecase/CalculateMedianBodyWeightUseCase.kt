package com.davidr10.gym.home.domain.usecase

import com.davidr10.gym.home.domain.repository.HomeRepository

class CalculateMedianBodyWeightUseCase(private val homeRepository: HomeRepository) {

    suspend operator fun invoke(): Double? {
        val weights = homeRepository.getAllWeightsInLastWeek()
        if (weights.isEmpty()) return null
        return weights[weights.size / 2]
    }
}
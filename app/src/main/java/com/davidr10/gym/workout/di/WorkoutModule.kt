package com.davidr10.gym.workout.di

import com.davidr10.gym.workout.data.repository.WorkoutRepositoryImpl
import com.davidr10.gym.workout.domain.repository.WorkoutRepository
import com.davidr10.gym.workout.domain.usecase.GetNextWorkouUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object WorkoutModule {

    @Provides
    @Singleton
    fun provideWorkoutRepository(): WorkoutRepository {
        return WorkoutRepositoryImpl()
    }
    @Provides
    @Singleton
    fun provideGetWorkoutCase(repository: WorkoutRepository): GetNextWorkouUseCase {
        return GetNextWorkouUseCase(repository)
    }
}
package com.davidr10.gym.home.di

import com.davidr10.gym.core.data.local.dao.ExerciseDao
import com.davidr10.gym.core.data.local.dao.RoutineDao
import com.davidr10.gym.core.data.local.dao.WorkoutDao
import com.davidr10.gym.core.data.local.dao.WorkoutLogDao
import com.davidr10.gym.core.data.local.dao.WorkoutSetDao
import com.davidr10.gym.home.data.repository.HomeRepositoryImpl
import com.davidr10.gym.home.domain.repository.HomeRepository
import com.davidr10.gym.home.domain.usecase.CalculateMedianBodyWeightUseCase
import com.davidr10.gym.home.domain.usecase.GetRoutinesUseCase
import com.davidr10.gym.home.domain.usecase.InsertRoutinesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object HomeModule {

    @Provides
    @Singleton
    fun provideHomeRepository(
        routineDao: RoutineDao,
        workoutSetDao: WorkoutSetDao,
        workoutDao: WorkoutDao,
        exerciseDao: ExerciseDao,
        workoutLogDao: WorkoutLogDao
    ): HomeRepository {
        return HomeRepositoryImpl(routineDao,workoutDao, exerciseDao, workoutSetDao, workoutLogDao)
    }
    @Provides
    @Singleton
    fun provideGetAllRoutinesCase(repository: HomeRepository): GetRoutinesUseCase {
        return GetRoutinesUseCase(repository)
    }
    @Provides
    @Singleton
    fun provideInsertRoutine(repository: HomeRepository): InsertRoutinesUseCase {
        return InsertRoutinesUseCase(repository)
    }
    @Provides
    @Singleton
    fun provideCalculateMedianBodyWeight(repository: HomeRepository): CalculateMedianBodyWeightUseCase {
        return CalculateMedianBodyWeightUseCase(repository)
    }
}
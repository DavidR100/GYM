package com.davidr10.gym.workout.di

import com.davidr10.gym.core.data.local.dao.ExerciseDao
import com.davidr10.gym.core.data.local.dao.RoutineDao
import com.davidr10.gym.core.data.local.dao.WorkoutDao
import com.davidr10.gym.core.data.local.dao.WorkoutLogDao
import com.davidr10.gym.core.data.local.dao.WorkoutSetDao
import com.davidr10.gym.workout.data.repository.WorkoutRepositoryImpl
import com.davidr10.gym.workout.domain.repository.WorkoutRepository
import com.davidr10.gym.workout.domain.usecase.CreateWorkoutUseCase
import com.davidr10.gym.workout.domain.usecase.FinishWorkoutUseCase
import com.davidr10.gym.workout.domain.usecase.GetNextWorkouIdUseCase
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
    fun provideWorkoutRepository(
        workoutDao: WorkoutDao,
        exerciseDao: ExerciseDao,
        workoutSetDao: WorkoutSetDao,
        workoutLogDao: WorkoutLogDao
    ): WorkoutRepository {
        return WorkoutRepositoryImpl(workoutDao,exerciseDao,workoutSetDao,workoutLogDao)
    }

    @Provides
    @Singleton
    fun provideGetWorkoutCase(repository: WorkoutRepository): GetNextWorkouIdUseCase {
        return GetNextWorkouIdUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideCreateWorkoutCase(repository: WorkoutRepository): CreateWorkoutUseCase {
        return CreateWorkoutUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideFinishWorkout(repository: WorkoutRepository): FinishWorkoutUseCase {
        return FinishWorkoutUseCase(repository)
    }


}
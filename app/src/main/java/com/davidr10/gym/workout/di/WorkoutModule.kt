package com.davidr10.gym.workout.di

import android.content.Context
import androidx.room.Room
import com.davidr10.gym.core.data.local.dao.ExerciseDao
import com.davidr10.gym.core.data.local.dao.RoutineDao
import com.davidr10.gym.core.data.local.dao.WorkoutDao
import com.davidr10.gym.core.data.local.dao.WorkoutLogDao
import com.davidr10.gym.core.data.local.dao.WorkoutSetDao
import com.davidr10.gym.core.data.local.database.WorkoutDatabase
import com.davidr10.gym.workout.data.repository.WorkoutRepositoryImpl
import com.davidr10.gym.workout.domain.repository.WorkoutRepository
import com.davidr10.gym.workout.domain.usecase.GetNextWorkouUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object WorkoutModule {

    @Provides
    @Singleton
    fun provideWorkoutRepository(
        routineDao: RoutineDao,
        workoutDao: WorkoutDao,
        exerciseDao: ExerciseDao,
        workoutSetDao: WorkoutSetDao
    ): WorkoutRepository {
        return WorkoutRepositoryImpl(routineDao,workoutDao,exerciseDao, workoutSetDao)
    }

    @Provides
    @Singleton
    fun provideGetWorkoutCase(repository: WorkoutRepository): GetNextWorkouUseCase {
        return GetNextWorkouUseCase(repository)
    }
}
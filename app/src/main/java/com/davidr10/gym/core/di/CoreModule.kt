package com.davidr10.gym.core.di

import android.content.Context
import androidx.room.Room
import com.davidr10.gym.core.data.local.dao.RoutineDao
import com.davidr10.gym.core.data.local.dao.WorkoutDao
import com.davidr10.gym.core.data.local.dao.WorkoutLogDao
import com.davidr10.gym.core.data.local.database.WorkoutDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object CoreModule {
    @Provides
    @Singleton
    fun provideWorkoutDatabase(@ApplicationContext contex: Context): WorkoutDatabase{
        return Room.databaseBuilder(contex,WorkoutDatabase::class.java, "workout_db").build()
    }
    @Provides
    @Singleton
    fun provideWorkoutDao(workoutDatabase: WorkoutDatabase): WorkoutDao {
        return workoutDatabase.workoutDao
    }
    @Provides
    @Singleton
    fun provideWorkoutLogDao(workoutDatabase: WorkoutDatabase): WorkoutLogDao {
        return workoutDatabase.workoutLogDao
    }
    @Provides
    @Singleton
    fun provideRoutineDao(workoutDatabase: WorkoutDatabase): RoutineDao {
        return workoutDatabase.routineDao
    }
}
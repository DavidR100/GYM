package com.davidr10.gym.home.di

import com.davidr10.gym.home.data.repository.HomeRepositoryImpl
import com.davidr10.gym.home.domain.repository.HomeRepository
import com.davidr10.gym.home.domain.usecase.GetRoutinesUseCase
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
    fun provideHomeRepository(): HomeRepository {
        return HomeRepositoryImpl()
    }
    @Provides
    @Singleton
    fun provideGetAllRoutinesCase(repository: HomeRepository): GetRoutinesUseCase {
        return GetRoutinesUseCase(repository)
    }
}
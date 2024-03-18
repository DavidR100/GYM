package com.davidr10.gym.workout.data.repository

import com.davidr10.gym.core.data.local.database.FakeDataBase
import com.davidr10.gym.core.domain.model.Workout
import com.davidr10.gym.workout.data.mapper.toDomain
import com.davidr10.gym.workout.domain.repository.WorkoutRepository

class WorkoutRepositoryImpl: WorkoutRepository {
    override suspend fun getNextWorkoutsByRoutine(id: String): List<Workout> {
        val workotA =  FakeDataBase.fakeWorkoutA
        val workotB =  FakeDataBase.fakeWorkoutB

        val exercisesA1 = FakeDataBase.fakeExercise1
        val exA1Set1= FakeDataBase.fakeSets1
        val exA1Set2= FakeDataBase.fakeSets2
        val exA1Set3= FakeDataBase.fakeSets3
        val exercisesA2 = FakeDataBase.fakeExercise2
        val exA2Set1= FakeDataBase.fakeSets4
        val exA2Set2= FakeDataBase.fakeSets5

        val exercisesB1 = FakeDataBase.fakeExercise3
        val exB1Set1= FakeDataBase.fakeSets6
        val exB1Set2= FakeDataBase.fakeSets7
        val exercisesB2 = FakeDataBase.fakeExercise4
        val exB2Set1= FakeDataBase.fakeSets8
        val exB2Set2= FakeDataBase.fakeSets9

        val setsA1 = listOf(exA1Set1.toDomain(), exA1Set2.toDomain(), exA1Set3.toDomain())
        val setsA2 = listOf(exA2Set1.toDomain(), exA2Set2.toDomain())

        val setsB1 = listOf(exB1Set1.toDomain(), exB1Set2.toDomain())
        val setsB2 = listOf(exB2Set1.toDomain(), exB2Set2.toDomain())


        val exercisesA = listOf(exercisesA1.toDomain(setsA1), exercisesA2.toDomain(setsA2))
        val exercisesB = listOf(exercisesB1.toDomain(setsB1), exercisesB2.toDomain(setsB2))

        return listOf(
            workotA.toDomain(exercisesA),
            workotB.toDomain(exercisesB)
        )
    }
}
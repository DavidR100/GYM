package com.davidr10.gym.workout.domain.usecase

import com.davidr10.gym.workout.domain.repository.WorkoutRepository

class GetNextWorkouIdUseCase(private val repository: WorkoutRepository) {
    suspend operator fun invoke(routineId: String): String {
        //1- Obtener todos los workouts de la rutina
        val workouts = repository.getAlltWorkoutsIdByRoutine(routineId)

        //2- Contar cuantos logs hay
        val workoutCount = repository.countAllWorkoutLogs(routineId)

        //3- Devolver la siguiente rutina basada en los logs
        return workouts[workoutCount % workouts.size]
    }
}
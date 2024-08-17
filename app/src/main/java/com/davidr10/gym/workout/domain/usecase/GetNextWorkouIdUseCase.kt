package com.davidr10.gym.workout.domain.usecase

import com.davidr10.gym.core.domain.model.Workout
import com.davidr10.gym.workout.domain.repository.WorkoutRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GetNextWorkouIdUseCase(private val repository: WorkoutRepository) {
    suspend operator fun invoke(routineId: String): String {
        return withContext(Dispatchers.IO){
            //1- Obtener todos los workouts de la rutina
            val workouts = repository.getAlltWorkoutsByRoutine(routineId)
            val workout = workouts.first()
            println(workout)

            //2 - Obtener ultimo log de la rutina por workout
            val lastWorkoutId = repository.getLastWorkoutLogInRoutine(routineId)

            //3- devolvernel id del sgt workout
            if (lastWorkoutId == null){
                workouts.first()
            }else {
                //4- Crear el nuevo workout
                //repository.getWorkoutById(workouts.first())

                val index = workouts.indexOf(lastWorkoutId)
                if (workouts.size > index + 1){
                    workout[index + 1]
                } else {
                    workouts.first()
                }

                ""

            }


        }
    }
}
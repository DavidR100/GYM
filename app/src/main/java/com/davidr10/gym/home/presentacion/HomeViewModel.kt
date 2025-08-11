package com.davidr10.gym.home.presentacion

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.davidr10.gym.core.domain.model.Exercise
import com.davidr10.gym.core.domain.model.Routine
import com.davidr10.gym.core.domain.model.Workout
import com.davidr10.gym.core.domain.model.WorkoutSet
import com.davidr10.gym.home.domain.usecase.CalculateMedianBodyWeightUseCase
import com.davidr10.gym.home.domain.usecase.GetRoutinesUseCase
import com.davidr10.gym.home.domain.usecase.InsertRoutinesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getRoutinesUseCase: GetRoutinesUseCase,
    private val insertRoutinesUseCase: InsertRoutinesUseCase,
    private val getMedianBodyWeightUseCase: CalculateMedianBodyWeightUseCase
) : ViewModel() {
    var state by mutableStateOf(HomeState())
        private set

    init {
        viewModelScope.launch {
            getRoutinesUseCase().collectLatest {
                state = state.copy(
                    routine = it
                )
            }
        }

        viewModelScope.launch {
            val weight = getMedianBodyWeightUseCase()
            state = state.copy(bodyWeiht = 83.0)
        }

        /* viewModelScope.launch {
             try {
                 insertRoutinesUseCase(FakeDataGenerator.createRoutine())
             } catch (e: Exception) {
                 println(e)
                 println()
             }
             println()
         }*/


    }
}
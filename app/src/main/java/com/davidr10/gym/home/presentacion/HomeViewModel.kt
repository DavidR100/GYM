package com.davidr10.gym.home.presentacion

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.davidr10.gym.home.domain.usecase.GetRoutinesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getRoutinesUseCase: GetRoutinesUseCase
): ViewModel(){
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
    }
}
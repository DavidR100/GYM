package com.davidr10.gym.workout.presentacion

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.hilt.navigation.compose.hiltViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WorkoutScreen(
    viewModel: WorkoutViewModel = hiltViewModel()
){
    val state = viewModel.state
    Column(modifier = Modifier.fillMaxSize()) {
        Row(modifier = Modifier.fillMaxWidth()) {
            TextField(value = state.bodyWeight, onValueChange = {
                viewModel.onEvent(WorkoutEvent.ChangeWeight(it))
            },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                maxLines = 1
            )

            Text(text = "${state.date}")
        }
        Button(onClick = {viewModel.onEvent(WorkoutEvent.FinishWorkout)}) {
            Text(text = "Finish Workout!")
        }
    }
}
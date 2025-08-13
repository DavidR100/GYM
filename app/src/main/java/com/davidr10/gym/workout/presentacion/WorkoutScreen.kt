package com.davidr10.gym.workout.presentacion

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.davidr10.gym.ui.theme.TextBlack
import com.davidr10.gym.workout.presentacion.composable.ExerciseItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WorkoutScreen(
    viewModel: WorkoutViewModel = hiltViewModel()
){
    val state = viewModel.state

    LazyColumn(modifier = Modifier.fillMaxSize(), contentPadding = PaddingValues(20.dp)) {
        item {
            Text(text = state.workout.name, color = TextBlack, fontSize = 20.sp, fontWeight = FontWeight.SemiBold)
        }
        item {
            Spacer(modifier = Modifier.height(20.dp))
        }
        itemsIndexed(state.workout.exercises){ index, exercise ->
            ExerciseItem(exercise = exercise, modifier = Modifier.fillMaxWidth())
            if (state.workout.exercises.lastIndex != index) {
                Spacer(modifier = Modifier.height(12.dp))
            }
        }
    }

}
package com.davidr10.gym.home.presentacion

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel(),
    onWorkoutClick: (String) -> Unit
){
    val state = viewModel.state
    LazyColumn(modifier = Modifier.fillMaxSize()){
        items(state.routine){
            TextButton(onClick = { onWorkoutClick(it.id) }) {
                Text(text = it.name)
            }
        }
    }
}
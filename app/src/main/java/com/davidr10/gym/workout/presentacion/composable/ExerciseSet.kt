package com.davidr10.gym.workout.presentacion.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.davidr10.gym.core.domain.model.WorkoutSet
import com.davidr10.gym.ui.theme.MainBlue

@Composable
fun ExerciseSet(
    set: WorkoutSet, modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Bottom
    ) {
        ExerciseSetInput(title = "Weight", currenValue = set.weight, onInput = {
        }, modifier = Modifier.weight(.2f), trailingText = "Kg")
        Spacer(modifier = Modifier.width(20.dp))
        ExerciseSetInput(title = "Repetitions", currenValue = set.repetitions, onInput = {
        }, modifier = Modifier.weight(.2f))
        Spacer(modifier = Modifier.width(20.dp))

        Button(
            onClick = {/*TODO*/ },
            colors = ButtonDefaults.buttonColors(
                containerColor = MainBlue,
                contentColor = Color.White
            ),
            modifier = Modifier.weight(.2f), shape = RoundedCornerShape(6.dp)
        ) {
            Text(text = "REST")
        }
    }
}
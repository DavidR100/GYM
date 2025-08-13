package com.davidr10.gym.workout.presentacion.composable

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.davidr10.gym.R
import com.davidr10.gym.core.domain.model.Exercise
import com.davidr10.gym.core.domain.model.WorkoutSet
import com.davidr10.gym.ui.theme.BlueBackground
import com.davidr10.gym.ui.theme.MainBlue
import com.davidr10.gym.ui.theme.TextBlack
import com.davidr10.gym.ui.theme.TextDescription

@Composable
fun ExerciseItem(
    exercise: Exercise,
    modifier: Modifier = Modifier
) {

    var isExpanded by remember {
        mutableStateOf(false)
    }
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(10.dp))
            .background(BlueBackground)
            .border(
                width = 1.dp,
                color = MainBlue.copy(alpha = .5f),
                shape = RoundedCornerShape(10.dp)
            )
            .padding(vertical = 14.dp, horizontal = 16.dp)
            .animateContentSize(),
        contentAlignment = Alignment.Center
    ) {
        Column {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Column(modifier = Modifier.weight(.6f)) {
                    Text(
                        text = exercise.name,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 18.sp,
                        color = TextBlack
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Lorem ipsum dolor sit amet consectetur. Platea prerium et ac.",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Medium,
                        color = TextDescription,
                        maxLines = 3,
                        lineHeight = 18.sp,
                        overflow = TextOverflow.Ellipsis
                    )
                }
                Image(
                    painter = painterResource(R.drawable.workout),
                    contentDescription = null,
                    modifier = Modifier.weight(.4f),
                    contentScale = ContentScale.Crop
                )
            }
            Spacer(modifier = Modifier.height(20.dp))
            Divider(modifier = Modifier.fillMaxWidth(), color = TextDescription.copy(alpha = .2f))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        isExpanded = !isExpanded
                    }
                    .padding(vertical = 6.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "See Details",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    color = TextBlack
                )
                val icon =
                    if (isExpanded) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown
                Icon(imageVector = icon, contentDescription = null)

            }
            if (isExpanded) {
                exercise.sets.forEachIndexed { index, workoutSet ->
                    ExerciseSet(workoutSet)
                    if (exercise.sets.lastIndex != index) {
                        Spacer(modifier = Modifier.height(12.dp))
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun ExerciseItemPreview() {
    ExerciseItem(
        Exercise(
            id = null,
            name = "Brench Press",
            sets = List(3) {
                WorkoutSet(id = null, weight = it * 20.0, repetitions = it * 3)
            }
        )
    )
}
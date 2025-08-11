package com.davidr10.gym.home.presentacion.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.davidr10.gym.R
import com.davidr10.gym.core.domain.model.Routine
import com.davidr10.gym.core.domain.model.Workout
import com.davidr10.gym.ui.theme.BlueBackground
import com.davidr10.gym.ui.theme.MainBlue
import com.davidr10.gym.ui.theme.TextBlack
import com.davidr10.gym.ui.theme.TextDescription

@Composable
fun HomeRoutine(routine: Routine, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(10.dp))
            .background(BlueBackground)
            .border(
                width = 1.dp,
                color = MainBlue.copy(alpha = .6f),
                shape = RoundedCornerShape(10.dp)
            )
            .padding(vertical = 14.dp, horizontal = 16.dp), contentAlignment = Alignment.Center
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Column(modifier = Modifier.weight(.5f)) {
                HomeDayPill(days = 3)
                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    text = routine.name,
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
                    maxLines = 4,
                    lineHeight = 18.sp,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(modifier = Modifier.height(42.dp))
                HomeTimer(time = 60)
            }
            Image(
                painter = painterResource(R.drawable.full_body),
                contentDescription = null,
                modifier = Modifier.weight(.4f),
                contentScale = ContentScale.Crop
            )
        }

    }
}

@Preview
@Composable
fun HomeRoutinePreview() {
    HomeRoutine(
        routine =
            Routine(
                id = null,
                name = "Full Strength",
                listOf()
            ), modifier = Modifier.fillMaxWidth()
    )
}
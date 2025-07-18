package com.davidr10.gym.home.presentacion

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.davidr10.gym.R

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel(),
    onRoutingClick: (Long) -> Unit
) {
    val state = viewModel.state

    LazyColumn(modifier = Modifier
        .fillMaxSize()
        .padding(horizontal = 20.dp),
        contentPadding = PaddingValues(vertical = 20.dp)
    ) {
        val appendable = buildAnnotatedString {
            append("Hello")
            append(" ")
            withStyle(style = SpanStyle(color = Color.Yellow)) {
                append("David")
            }
        }
        item {
            Text(text = appendable)
            Text(text = "Let´s start you day", fontSize = 24.sp, fontWeight = FontWeight.SemiBold)
        }

        item { Spacer(modifier = Modifier.height(40.dp)) }
        item { Text(text = "Workouts", fontWeight = FontWeight.SemiBold, fontSize = 16.sp) }
        item { Spacer(modifier = Modifier.height(24.dp)) }

        items(state.routine) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .clickable { onRoutingClick(it.id!!) }
            ) {
                Image(
                    painter = painterResource(id = R.drawable.workout_background),
                    contentDescription = null,
                    modifier = Modifier.fillMaxWidth(),
                    contentScale = ContentScale.Crop
                )
                Text(
                    text = it.name,
                    modifier = Modifier.align(alignment = Alignment.BottomStart).padding(start = 16.dp, bottom = 10.dp),
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    color = Color.White
                )
            }
        }
    }
}
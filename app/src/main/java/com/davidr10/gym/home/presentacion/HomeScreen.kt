package com.davidr10.gym.home.presentacion

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
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
import com.davidr10.gym.home.presentacion.composable.HomeRoutine
import com.davidr10.gym.home.presentacion.composable.HomeWeight
import com.davidr10.gym.ui.theme.MainBlue
import com.davidr10.gym.ui.theme.TextBlack

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel(),
    onRoutingClick: (Long) -> Unit
) {
    val state = viewModel.state

    LazyColumn(
        modifier = Modifier
            .fillMaxSize(),
        contentPadding = PaddingValues(20.dp)
    ) {
        item {
            state.bodyWeiht?.let {
                Column {
                    Text(
                        text = "Weekly Summary",
                        color = TextBlack,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 16.sp
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                    HomeWeight(it, modifier = Modifier.fillMaxWidth())
                    Spacer(modifier = Modifier.height(18.dp))
                }
            }

        }
        item {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Workout Plans",
                    color = TextBlack,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 16.sp
                )
                TextButton(onClick = {}) {
                    Text(
                        text = "See all",
                        color = MainBlue,
                        fontWeight = FontWeight.Medium,
                        fontSize = 12.sp
                    )
                }
            }
        }
        item { Spacer(modifier = Modifier.height(12.dp)) }

        items(state.routine) {
            HomeRoutine(it, modifier = Modifier.fillMaxWidth()) {
                onRoutingClick(it.id!!)
            }
        }
    }
}
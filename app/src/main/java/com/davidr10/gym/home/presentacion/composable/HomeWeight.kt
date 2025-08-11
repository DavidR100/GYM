package com.davidr10.gym.home.presentacion.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.davidr10.gym.R
import com.davidr10.gym.ui.theme.BlueBackground
import com.davidr10.gym.ui.theme.MainBlue
import com.davidr10.gym.ui.theme.TextBlack
import com.davidr10.gym.ui.theme.WeightText

@Composable
fun HomeWeight(bodyWeight: Double, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(10.dp))
            .background(BlueBackground)
            .border(width = 1.dp, color = MainBlue.copy(alpha = .5f), shape = RoundedCornerShape(10.dp)), contentAlignment = Alignment.Center
    ) {
        Column(modifier = Modifier.padding(vertical = 12.dp)) {
            Row {
                Icon(
                    painter = painterResource(R.drawable.ic_scale),
                    contentDescription = "Icono Scale",
                    modifier = Modifier.size(22.dp),
                    tint = MainBlue
                )
                Spacer(modifier = Modifier.width(6.dp))
                Text(
                    text = "Average Weight", color = WeightText, fontSize = 14.sp,
                    fontWeight = FontWeight.Medium
                )
            }

            val text = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.Bold,
                        color = TextBlack,
                        fontSize = 20.sp
                    )
                ) {
                    append("$bodyWeight")
                }
                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.Medium,
                        color = TextBlack,
                        fontSize = 14.sp
                    )
                ) {
                    append("Kg")
                }
            }

            Text(text = text, modifier = Modifier.align(CenterHorizontally))

        }
    }
}

@Preview
@Composable
fun HomeWeightPreview() {
    HomeWeight(bodyWeight = 80.0, modifier = Modifier.fillMaxWidth())
}
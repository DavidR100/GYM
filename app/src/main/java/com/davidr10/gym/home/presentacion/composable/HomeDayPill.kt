package com.davidr10.gym.home.presentacion.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.davidr10.gym.ui.theme.TextBlack

@Composable
fun HomeDayPill(
    days: Int,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(3.dp))
            .background(Color.White)
            .padding(horizontal = 8.dp, vertical = 4.dp),
        contentAlignment = Alignment.Center
    ) {
        val text = if (days == 1) "Day" else "Days"
        Text(
            text = "$days $text",
            fontWeight = FontWeight.Medium,
            color = TextBlack,
            fontSize = 10.sp
        )
    }
}

@Preview
@Composable
fun HomeDayPillPreview() {
    HomeDayPill(
        1
    )
}
package com.davidr10.gym.home.presentacion.composable

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.davidr10.gym.R
import com.davidr10.gym.ui.theme.MainBlue
import com.davidr10.gym.ui.theme.TextBlack

@Composable
fun HomeTimer(
    time: Int,
    modifier: Modifier = Modifier
) {
    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
        Icon(
            painter = painterResource(R.drawable.ic_timer),
            contentDescription = "Icono Timer",
            modifier = Modifier.size(22.dp),
            tint = MainBlue
        )
        Spacer(modifier = Modifier.width(6.dp))
        Text(text = "60 Mins", color = TextBlack, fontWeight = FontWeight.Medium, fontSize = 14.sp)
    }

}

@Preview
@Composable
fun HomeTimerPreview() {
    HomeTimer(60)
}
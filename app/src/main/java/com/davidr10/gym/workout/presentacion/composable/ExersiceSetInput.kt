package com.davidr10.gym.workout.presentacion.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.davidr10.gym.ui.theme.MainBlue
import com.davidr10.gym.ui.theme.TextBlack
import com.davidr10.gym.ui.theme.TextDescription

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun <T : Number> ExerciseSetInput(
    title: String,
    currenValue: T,
    onInput: (String) -> Unit,
    modifier: Modifier = Modifier,
    trailingText: String? = null
) {
    Column(modifier = modifier) {
        Text(
            text = title,
            color = TextDescription,
            fontSize = 12.sp,
            fontWeight = FontWeight.Medium
        )
        Spacer(modifier = Modifier.height(6.dp))
        CustomTexField(
            currenValue = currenValue.toString(),
            onInput = { onInput(it) },
            trailingText = trailingText,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
private fun CustomTexField(
    currenValue: String,
    onInput: (String) -> Unit,
    modifier: Modifier = Modifier,
    trailingText: String? = null
) {
    BasicTextField(
        modifier = modifier
            .border(1.dp, color = TextDescription.copy(alpha = .2f))
            .background(color = Color.White, shape = RoundedCornerShape(6.dp))
            .height(36.dp),
        value = currenValue,
        onValueChange = {
            onInput(it)
        },
        singleLine = true,
        textStyle = LocalTextStyle.current.copy(
            color = TextBlack,
            fontSize = 12.sp,
            fontWeight = FontWeight.SemiBold,
            textAlign = TextAlign.Center
        ),
        decorationBox = { innerTextField ->
            Row(
                modifier = Modifier.padding(horizontal = 8.5.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(modifier = Modifier.weight(1f)) {
                    innerTextField()
                }
                if (trailingText != null) {
                    Text(
                        text = trailingText,
                        color = TextBlack, fontSize = 12.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Decimal
        ),
        maxLines = 1,
        cursorBrush = SolidColor(MainBlue)
    )
}

@Preview
@Composable
fun ExerciseSetInputPreview() {
    ExerciseSetInput(
        title = "Weight", currenValue = 30.0,
        {})
}
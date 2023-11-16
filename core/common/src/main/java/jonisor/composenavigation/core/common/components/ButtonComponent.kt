package jonisor.composenavigation.core.common.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ButtonComponent(
    text: String,
    onClick: () -> Unit
) {
    Button(
        onClick = { onClick() },
        modifier = Modifier.fillMaxWidth(),
        border = BorderStroke(
          width = 1.dp,
          color = Color.Black
        ),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.Yellow
        )
    ) {
        TextComponent(
            text = text,
            style = MaterialTheme.typography.button
        )
    }
}
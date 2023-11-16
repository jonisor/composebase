package jonisor.composenavigation.core.common.components

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle

@Composable
fun TextComponent(
    text: String,
    style: TextStyle = MaterialTheme.typography.body1
) {
    Text(
        text = text,
        style = style
    )
}
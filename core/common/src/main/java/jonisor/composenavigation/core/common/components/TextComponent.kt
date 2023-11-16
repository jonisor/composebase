package jonisor.composenavigation.core.common.components

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign

@Composable
fun TextComponent(
    text: String,
    textAlign: TextAlign = TextAlign.Center,
    style: TextStyle = MaterialTheme.typography.body1
) {
    Text(
        text = text,
        textAlign = textAlign,
        style = style
    )
}
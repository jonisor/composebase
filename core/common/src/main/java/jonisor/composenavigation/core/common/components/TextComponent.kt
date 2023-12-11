package jonisor.composenavigation.core.common.components

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration

@Composable
fun TextComponent(
    text: String,
    textAlign: TextAlign = TextAlign.Center,
    textDecoration: TextDecoration = TextDecoration.None,
    style: TextStyle = MaterialTheme.typography.body1
) {
    Text(
        text = text,
        textAlign = textAlign,
        textDecoration = textDecoration,
        style = style
    )
}
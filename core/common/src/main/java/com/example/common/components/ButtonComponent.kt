package com.example.common.components

import androidx.compose.material.Button
import androidx.compose.runtime.Composable

@Composable
fun ButtonComponent(
    text: String,
    onClick: () -> Unit
) {
    Button(
        onClick = { onClick() }
    ) {
        TextComponent(text = text)
    }
}
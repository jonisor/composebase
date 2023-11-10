package com.example.common.components

import androidx.compose.material.Button
import androidx.compose.runtime.Composable

@Composable
fun ButtonComponent(
    onClick: () -> Unit
) {
    Button(
        onClick = { onClick() }
    ) {
        TextComponent(text = "Navigate to latest")
    }
}
package com.example.composenavigation.feature.latest.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.common.components.ButtonComponent
import com.example.common.components.TextComponent
import com.ramcosta.composedestinations.annotation.Destination

interface LatestScreenNavigator {
    fun popBackStack()
    fun navigateToHomeScreen()
}

@Destination
@Composable
fun LatestScreen(
    navigator: LatestScreenNavigator,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        TextComponent(text = "Latest")
        ButtonComponent(
            onClick = { navigator.popBackStack() }
        )
    }
}
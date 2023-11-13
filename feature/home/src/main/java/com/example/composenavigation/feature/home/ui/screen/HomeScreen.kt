package com.example.composenavigation.feature.home.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.common.components.ButtonComponent
import com.example.common.components.TextComponent
import com.ramcosta.composedestinations.annotation.Destination

interface HomeScreenNavigator {
    fun popBackStack()
    fun navigateToLatest()
}

@Destination
@Composable
fun HomeScreen(
    navigator: HomeScreenNavigator,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        TextComponent(text = "Home")
        ButtonComponent(
            text = "Navigate to latest",
            onClick = { navigator.navigateToLatest() }
        )
    }
}
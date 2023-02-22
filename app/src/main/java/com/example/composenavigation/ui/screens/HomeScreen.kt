package com.example.composenavigation.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.common.components.TextComponent
import com.example.composenavigation.ui.screens.destinations.ProfileScreenDestination
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@RootNavGraph(start = true)
@Destination
@Composable
fun HomeScreen(
    navigator: DestinationsNavigator
) {
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp)
    ) {
        TextComponent(text = "Home")
        Button(onClick = {
            navigator.navigate(
                ProfileScreenDestination(
                    id = 7,
                    userName = "User"
                )
            )
        }) {
            TextComponent(text = "Go to profile")
        }
    }
}
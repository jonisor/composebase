package com.example.composenavigation.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.common.components.TextComponent
import com.example.composenavigation.ui.screens.destinations.HomeScreenDestination
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination
@Composable
fun ProfileScreen(
    navigator: DestinationsNavigator,
    id: Int,
    userName: String
) {
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp)
    ) {
        TextComponent(text = "Profile")
        Button(onClick = {
            navigator.navigate(
                HomeScreenDestination
            )
        }) {
            TextComponent(text = "Go home, $userName")
        }
    }
}
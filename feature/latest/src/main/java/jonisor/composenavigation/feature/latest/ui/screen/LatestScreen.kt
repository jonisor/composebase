package jonisor.composenavigation.feature.latest.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import jonisor.composenavigation.core.common.components.ButtonComponent
import jonisor.composenavigation.core.common.components.TextComponent
import jonisor.composenavigation.feature.latest.ui.viewmodel.LatestViewModel
import com.ramcosta.composedestinations.annotation.Destination

interface LatestScreenNavigator {
    fun popBackStack()
    fun navigateToHomeScreen()
}

@Destination
@Composable
fun LatestScreen(
    navigator: LatestScreenNavigator,
    latestViewModel: LatestViewModel = hiltViewModel()
) {
    LaunchedEffect(true) {
        latestViewModel.initialise()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        TextComponent(text = "Latest")
        ButtonComponent(
            text = "Return home",
            onClick = { navigator.popBackStack() }
        )
    }
}
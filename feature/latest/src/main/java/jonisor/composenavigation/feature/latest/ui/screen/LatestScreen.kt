package jonisor.composenavigation.feature.latest.ui.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import jonisor.composenavigation.core.common.components.ButtonComponent
import jonisor.composenavigation.core.common.components.TextComponent
import jonisor.composenavigation.feature.latest.ui.viewmodel.LatestViewModel
import com.ramcosta.composedestinations.annotation.Destination
import jonisor.composenavigation.core.common.theme.AppTheme
import jonisor.composenavigation.feature.latest.R

interface LatestScreenNavigator {
    fun popBackStack()
    fun navigateToHomeScreen()
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Destination
@Composable
fun LatestScreen(
    navigator: LatestScreenNavigator,
    latestViewModel: LatestViewModel = hiltViewModel()
) {
    LaunchedEffect(true) {
        latestViewModel.initialise()
    }

    Scaffold(
        bottomBar = {
            Box(modifier = Modifier.padding(AppTheme.dimensions.paddingRegular)) {
                ButtonComponent(
                    text = stringResource(id = R.string.SCREEN_LATEST_BUTTON_TITLE),
                    onClick = { navigator.popBackStack() }
                )
            }
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(AppTheme.dimensions.paddingRegular)
        ) {
            TextComponent(
                text = stringResource(id = R.string.SCREEN_LATEST_TITLE),
                style = MaterialTheme.typography.h4
            )
        }
    }
}
package jonisor.composenavigation.feature.home.ui.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import jonisor.composenavigation.core.common.components.ButtonComponent
import jonisor.composenavigation.core.common.components.TextComponent
import com.ramcosta.composedestinations.annotation.Destination
import jonisor.composenavigation.core.common.theme.AppTheme
import jonisor.composenavigation.feature.home.R

interface HomeScreenNavigator {
    fun popBackStack()
    fun navigateToLatest()
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Destination
@Composable
fun HomeScreen(
    navigator: HomeScreenNavigator,
) {
    Scaffold(
        bottomBar = {
            Box(modifier = Modifier.padding(AppTheme.dimensions.paddingRegular)) {
                ButtonComponent(
                    text = stringResource(id = R.string.SCREEN_HOME_BUTTON_TITLE),
                    onClick = { navigator.navigateToLatest() }
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
                text = stringResource(id = R.string.SCREEN_HOME_TITLE),
                style = MaterialTheme.typography.h4
            )
        }
    }
}
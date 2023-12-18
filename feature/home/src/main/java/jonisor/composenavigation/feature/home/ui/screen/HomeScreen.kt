package jonisor.composenavigation.feature.home.ui.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import jonisor.composenavigation.core.common.components.ButtonComponent
import jonisor.composenavigation.core.common.components.TextComponent
import com.ramcosta.composedestinations.annotation.Destination
import jonisor.composenavigation.core.common.theme.AppTheme
import jonisor.composenavigation.feature.home.R
import jonisor.composenavigation.feature.home.ui.component.BottomComponent
import jonisor.composenavigation.feature.home.ui.component.TopComponent

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
        topBar = {
            TopComponent()
        },
        bottomBar = {
            BottomComponent(navigator)
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(AppTheme.dimensions.paddingRegular)
        ) {
            TextComponent(
                text = stringResource(id = R.string.SCREEN_HOME_SUBTITLE),
                textAlign = TextAlign.Start,
                style = MaterialTheme.typography.subtitle1
            )
        }
    }
}
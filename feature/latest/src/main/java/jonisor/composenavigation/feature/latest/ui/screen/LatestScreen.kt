package jonisor.composenavigation.feature.latest.ui.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import jonisor.composenavigation.core.common.components.ButtonComponent
import jonisor.composenavigation.feature.latest.ui.viewmodel.LatestViewModel
import com.ramcosta.composedestinations.annotation.Destination
import jonisor.composenavigation.core.common.components.TextComponent
import jonisor.composenavigation.core.common.components.TopBarComponent
import jonisor.composenavigation.core.common.theme.AppTheme
import jonisor.composenavigation.feature.latest.R
import jonisor.composenavigation.feature.latest.ui.component.AdCard

interface LatestScreenNavigator {
    fun popBackStack()
    fun navigateToHomeScreen()
    fun navigateToArtistAdScreen(id: String)
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Destination
@Composable
fun LatestScreen(
    navigator: LatestScreenNavigator,
    latestViewModel: LatestViewModel = hiltViewModel()
) {
    val uiState by latestViewModel.uiState.collectAsState()

    Scaffold(
        topBar = {
            TopBarComponent(
                onClick = { navigator.popBackStack() },
                title = "Back"
            )
        },
        bottomBar = {
            Box(modifier = Modifier.padding(AppTheme.dimensions.paddingRegular)) {
                ButtonComponent(
                    text = stringResource(id = R.string.SCREEN_LATEST_ADD_AD),
                    onClick = { /**/ }
                )
            }
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(AppTheme.dimensions.paddingRegular)
        ) {
            if (uiState.artistsAds?.isNotEmpty() == true) {
                LazyColumn(modifier = Modifier.fillMaxSize()) {
                    item {
                        Box(modifier = Modifier.padding(bottom = AppTheme.dimensions.paddingRegular)) {
                            TextComponent(
                                text = stringResource(id = R.string.SCREEN_LATEST_TITLE),
                                style = MaterialTheme.typography.subtitle1
                            )
                        }
                    }
                    items(uiState.artistsAds!!.size) {
                        AdCard(
                            ad = uiState.artistsAds!![it],
                            onClick = navigator::navigateToArtistAdScreen
                        )
                    }
                }
            }
        }
    }
}
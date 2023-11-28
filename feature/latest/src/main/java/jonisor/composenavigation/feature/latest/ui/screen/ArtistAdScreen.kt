package jonisor.composenavigation.feature.latest.ui.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.ramcosta.composedestinations.annotation.Destination
import jonisor.composenavigation.core.common.components.TextComponent
import jonisor.composenavigation.core.common.components.TopBarComponent
import jonisor.composenavigation.core.common.theme.AppTheme
import jonisor.composenavigation.feature.latest.ui.model.ArtistAdScreenNavArgs
import jonisor.composenavigation.feature.latest.ui.viewmodel.ArtistAdScreenViewModel

interface ArtistAdScreenNavigator {
    fun popBackStack()
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Destination(navArgsDelegate = ArtistAdScreenNavArgs::class)
@Composable
fun ArtistAdScreen(
    navigator: ArtistAdScreenNavigator,
    artistAdScreenViewModel: ArtistAdScreenViewModel = hiltViewModel()
) {
    val uiState by artistAdScreenViewModel.uiState.collectAsState()

    Scaffold(
        topBar = {
            TopBarComponent(
                onClick = { navigator.popBackStack() },
                title = "Return"
            )
        }
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            uiState.ad?.let {
                Box(modifier = Modifier.padding(AppTheme.dimensions.paddingRegular)) {
                    TextComponent(
                        text = it.title,
                        style = MaterialTheme.typography.subtitle1
                    )
                }
            }
        }
    }
}
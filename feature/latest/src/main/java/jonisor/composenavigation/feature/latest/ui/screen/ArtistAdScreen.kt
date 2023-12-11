package jonisor.composenavigation.feature.latest.ui.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ramcosta.composedestinations.annotation.Destination
import jonisor.composenavigation.core.common.components.ImageComponent
import jonisor.composenavigation.core.common.components.TextComponent
import jonisor.composenavigation.core.common.components.TopBarComponent
import jonisor.composenavigation.core.common.theme.AppTheme
import jonisor.composenavigation.feature.latest.R
import jonisor.composenavigation.feature.latest.ui.component.AdItem
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
            uiState.ad?.let { ad ->
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(AppTheme.dimensions.paddingRegular),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(AppTheme.dimensions.paddingRegular),
                ) {
                    TextComponent(
                        text = ad.title,
                        style = MaterialTheme.typography.h3
                    )
                    ad.imageUrl?.let {
                        ImageComponent(
                            imageUrl = it,
                            size = 240.dp
                        )
                    }
                    ad.description?.let {
                        TextComponent(
                            text = it,
                            style = MaterialTheme.typography.body1
                        )
                    }
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        verticalArrangement = Arrangement.spacedBy(AppTheme.dimensions.paddingXXSmall)
                    ) {
                        ad.estimateCost?.let {
                            AdItem(
                                field = R.string.SCREEN_AD_ITEM_COST,
                                value = it.toString()
                            )
                        }
                        ad.estimateDuration?.let {
                            AdItem(
                                field = R.string.SCREEN_AD_ITEM_DURATION,
                                value = it.toString()
                            )
                        }
                        if (ad.targetArea?.isEmpty() == false) {
                            val targets = StringBuilder()
                            ad.targetArea!!.map {
                                targets
                                    .append(it.value.lowercase())
                                    .append(" ")
                            }

                            AdItem(
                                field = R.string.SCREEN_AD_ITEM_TARGET_AREA,
                                value = targets.toString()
                            )
                        }
                    }
                }
            }
        }
    }
}
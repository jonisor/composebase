package jonisor.composenavigation.feature.latest.ui.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import jonisor.composenavigation.core.common.components.CustomImage
import jonisor.composenavigation.core.common.components.TextComponent
import jonisor.composenavigation.core.common.theme.AppTheme
import jonisor.composenavigation.core.data.model.ArtistAd

@Composable
fun AdCard(ad: ArtistAd) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = AppTheme.dimensions.paddingRegular)
    ) {
        Row {
            Box(modifier = Modifier.padding(AppTheme.dimensions.paddingRegular)) {
                ad.imageUrl?.let { CustomImage(imageUrl = it) }
            }
            Column {
                TextComponent(
                    text = ad.title,
                    style = MaterialTheme.typography.subtitle1,
                    textAlign = TextAlign.Start
                )
                TextComponent(
                    text = ad.description,
                    textAlign = TextAlign.Start
                )
                Spacer(modifier = Modifier.size(AppTheme.dimensions.paddingRegular))
            }
        }
    }
}
package jonisor.composenavigation.feature.home.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import jonisor.composenavigation.core.common.components.TextComponent
import jonisor.composenavigation.core.common.theme.AppTheme
import jonisor.composenavigation.feature.home.R
import jonisor.composenavigation.feature.home.ui.screen.HomeScreenNavigator

@Composable
fun BottomComponent(
    navigator: HomeScreenNavigator
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = AppTheme.dimensions.paddingRegular,
                vertical = AppTheme.dimensions.paddingLarge
            )
        ,
        verticalArrangement = Arrangement.spacedBy(AppTheme.dimensions.paddingSmall),
        horizontalAlignment = Alignment.End
    ) {
        Row(
            modifier = Modifier.clickable { navigator.navigateToLatest() },
            horizontalArrangement = Arrangement.spacedBy(AppTheme.dimensions.paddingExtraSmall)
        ) {
            TextComponent(
                text = stringResource(id = R.string.SCREEN_HOME_BOTTOM_LATEST_AD_ARTIST),
                textDecoration = TextDecoration.Underline,
                style = MaterialTheme.typography.h3
            )
            Box(modifier = Modifier.size(48.dp)) {
                Image(
                    painter = painterResource(
                        id = R.drawable.rose
                    ),
                    contentDescription = "background",
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier.matchParentSize()
                )
            }
        }
        Row(
            modifier = Modifier.clickable {  },
            horizontalArrangement = Arrangement.spacedBy(AppTheme.dimensions.paddingExtraSmall)
        ) {
            TextComponent(
                text = stringResource(id = R.string.SCREEN_HOME_BOTTOM_LATEST_AD_CLIENT),
                textDecoration = TextDecoration.Underline,
                style = MaterialTheme.typography.h3
            )
            Box(modifier = Modifier.size(48.dp)) {
                Image(
                    painter = painterResource(
                        id = R.drawable.rose
                    ),
                    contentDescription = "background",
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier.matchParentSize()
                )
            }
        }
    }
}
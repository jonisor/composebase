package jonisor.composenavigation.feature.home.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import jonisor.composenavigation.core.common.components.TextComponent
import jonisor.composenavigation.core.common.theme.AppTheme
import jonisor.composenavigation.feature.home.R

@Composable
fun TopComponent() {
    Box(modifier = Modifier
        .height(104.dp)
        .fillMaxWidth()
        .background(
            brush = Brush.verticalGradient(
                colors = listOf(
                    MaterialTheme.colors.primary,
                    MaterialTheme.colors.background,
                    MaterialTheme.colors.background
                )
            )
        )
        .padding(
            horizontal = AppTheme.dimensions.paddingRegular,
            vertical = AppTheme.dimensions.paddingLarge
        )
    ) {
        TextComponent(
            text = stringResource(id = R.string.SCREEN_HOME_TITLE),
            style = MaterialTheme.typography.h6
        )
    }
}
package jonisor.composenavigation.feature.latest.ui.component

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import jonisor.composenavigation.core.common.components.TextComponent
import jonisor.composenavigation.core.common.theme.AppTheme

@Composable
fun AdItem(
    @StringRes field: Int,
    value: String
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(AppTheme.dimensions.paddingXXSmall)
    ) {
        TextComponent(text = stringResource(id = field))
        TextComponent(
            text = value,
            style = MaterialTheme.typography.body2
        )
    }
}
package jonisor.composenavigation.core.common.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import jonisor.composenavigation.core.common.theme.AppTheme

@Composable
fun TopBarComponent(
    onClick: () -> Unit,
    title: String
) {
    Surface(
        modifier = Modifier
            .height(48.dp)
            .fillMaxWidth()
            .padding(horizontal = AppTheme.dimensions.paddingRegular)
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null,
            ) {
                onClick()
            },
    ) {
        Box(modifier = Modifier.background(
            color = MaterialTheme.colors.primary)
        ) {
            TextComponent(text = title)
        }
    }
}
package jonisor.composenavigation.core.common.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class Dimensions(
    val paddingRegular: Dp = 16.dp,
)

internal val LocalDimensions = staticCompositionLocalOf { Dimensions() }
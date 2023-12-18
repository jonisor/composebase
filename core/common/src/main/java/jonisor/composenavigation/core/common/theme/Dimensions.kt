package jonisor.composenavigation.core.common.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class Dimensions(
    val paddingXXSmall: Dp = 4.dp,
    val paddingExtraSmall: Dp = 8.dp,
    val paddingSmall: Dp = 12.dp,
    val paddingRegular: Dp = 16.dp,
    val paddingLarge: Dp = 20.dp,
    val paddingExtraLarge: Dp = 24.dp
)

internal val LocalDimensions = staticCompositionLocalOf { Dimensions() }
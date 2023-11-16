package jonisor.composenavigation.core.common.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import jonisor.composenavigation.core.common.R


val defaultFontFamily = FontFamily(
    Font(R.font.nunitosans_black, FontWeight.Black),
    Font(R.font.nunitosans_bold, FontWeight.Bold),
    Font(R.font.nunitosans_extrabold, FontWeight.ExtraBold),
    Font(R.font.nunitosans_regular, FontWeight.Normal)
)

val CustomTypography = Typography(
    body1 = TextStyle(
        fontFamily = defaultFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 20.sp
    ),
    body2 = TextStyle(
        fontFamily = defaultFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 16.sp
    ),
    button = TextStyle(
        fontFamily = defaultFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp,
        lineHeight = 20.sp
    )
)
package jonisor.composenavigation.core.common.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest

@Composable
fun CustomImage(
    imageUrl: String,
    contentScale: ContentScale = ContentScale.FillWidth
) {
    Box(modifier = Modifier.size(120.dp)) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(imageUrl)
                .crossfade(true)
                .build(),
            contentDescription = "Ad Card image",
            contentScale = contentScale,
            modifier = Modifier
                .fillMaxSize()
        )
    }
}
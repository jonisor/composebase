package jonisor.composenavigation.core.data.model

data class ArtistAd(
    val id: String,
    val title: String,
    val description: String,
    val imageUrl: String? = null,
    val estimateDuration: Int? = null,
    val estimateCost: Int? = null,
    val targetArea: List<TargetArea>? = emptyList(),
    val artistId: String
)

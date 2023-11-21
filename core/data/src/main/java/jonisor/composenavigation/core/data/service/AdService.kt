package jonisor.composenavigation.core.data.service

import jonisor.composenavigation.core.data.model.ArtistAd
import retrofit2.http.GET

interface AdService {
    @GET("ads/artists")
    suspend fun getArtistsAds(): List<ArtistAd>
}
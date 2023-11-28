package jonisor.composenavigation.core.data.service

import jonisor.composenavigation.core.data.model.ArtistAd
import retrofit2.http.GET
import retrofit2.http.Path

interface AdService {
    @GET("ads/artists")
    suspend fun getArtistsAds(): List<ArtistAd>

    @GET("ads/{id}")
    suspend fun getAd(@Path("id") id: String): ArtistAd?
}
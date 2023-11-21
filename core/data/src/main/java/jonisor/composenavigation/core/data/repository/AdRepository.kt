package jonisor.composenavigation.core.data.repository

import android.util.Log
import jonisor.composenavigation.core.data.model.ArtistAd
import jonisor.composenavigation.core.data.service.AdService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AdRepository @Inject constructor(
    private val adService: AdService
) {
    suspend fun getArtistsAds(): List<ArtistAd>? {
        return try {
            adService.getArtistsAds()

        } catch (e: Exception) {
            e.message?.let { Log.d("TESTING", it) }
            return null
        }
    }
}
package jonisor.composenavigation.core.data.repository

import android.util.Log
import jonisor.composenavigation.core.data.model.Artist
import jonisor.composenavigation.core.data.service.ArtistService
import javax.inject.Inject

class ArtistRepository @Inject constructor(
    private val artistService: ArtistService
) {
    suspend fun getArtist(id: String): Artist? {
        return try {
            artistService.getArtist(id)
        } catch (e: Exception) {
            e.message?.let { Log.d("TESTING", it) }
            return null
        }
    }
}
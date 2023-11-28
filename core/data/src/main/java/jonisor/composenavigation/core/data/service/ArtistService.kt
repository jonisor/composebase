package jonisor.composenavigation.core.data.service

import jonisor.composenavigation.core.data.model.Artist
import retrofit2.http.GET
import retrofit2.http.Path

interface ArtistService {
    @GET("artists/{id}")
    suspend fun getArtist(@Path("id") id: String): Artist?
}
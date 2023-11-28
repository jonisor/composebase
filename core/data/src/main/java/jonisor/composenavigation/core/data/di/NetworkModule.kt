package jonisor.composenavigation.core.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import jonisor.composenavigation.core.data.service.AdService
import jonisor.composenavigation.core.data.service.ArtistService
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {
    @Singleton
    @Provides
    fun provideAdService(retrofit: Retrofit):
            AdService = retrofit.create(AdService::class.java)

    @Singleton
    @Provides
    fun provideArtistService(retrofit: Retrofit):
            ArtistService = retrofit.create(ArtistService::class.java)
}
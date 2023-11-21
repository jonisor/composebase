package jonisor.composenavigation.core.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import jonisor.composenavigation.core.data.service.AdService
import jonisor.composenavigation.core.data.service.UserService
import retrofit2.Retrofit
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {
    @Singleton
    @Provides
    fun provideUserService(retrofit: Retrofit):
            UserService = retrofit.create(UserService::class.java)

    @Singleton
    @Provides
    fun provideAdService(retrofit: Retrofit):
            AdService = retrofit.create(AdService::class.java)
}
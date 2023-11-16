package jonisor.composenavigation.core.data.di

import jonisor.composenavigation.core.data.service.TestService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {
    @Singleton
    @Provides
    fun provideTestService(retrofit: Retrofit):
            TestService = retrofit.create(TestService::class.java)
}
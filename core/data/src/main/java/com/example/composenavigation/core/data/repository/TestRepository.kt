package com.example.composenavigation.core.data.repository

import com.example.composenavigation.core.data.service.TestResponse
import com.example.composenavigation.core.data.service.TestService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TestRepository @Inject constructor(
    private val testService: TestService
) {
    suspend fun getTest(): TestResponse {
        return testService.tester()
    }
}
package com.example.composenavigation.core.data.repository

import android.util.Log
import com.example.composenavigation.core.data.service.TestResponse
import com.example.composenavigation.core.data.service.TestService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TestRepository @Inject constructor(
    private val testService: TestService
) {
    suspend fun getTest(): TestResponse? {
        return try {
            testService.tester()

        } catch (e: Exception) {
            e.message?.let { Log.d("TESTING", it) }
            return null
        }
    }
}
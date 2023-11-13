package com.example.composenavigation.core.data.service

import com.google.gson.annotations.SerializedName
import retrofit2.http.GET

data class TestResponse(
    @SerializedName("userId")
    val userId: Int,
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("completed")
    val completed: Boolean
)

interface TestService {
    @GET("todos/1")
    suspend fun tester(): TestResponse
}
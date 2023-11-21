package jonisor.composenavigation.core.data.service

import jonisor.composenavigation.core.data.model.User
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface UserService {
    @GET("getallusers")
    suspend fun getAllUsers(): List<User>

    @GET("users/{id}")
    suspend fun getUser(@Path("id") id: String): User?

    @POST("users/create")
    suspend fun addUser(
        @Body user: User
    ): List<User>
}
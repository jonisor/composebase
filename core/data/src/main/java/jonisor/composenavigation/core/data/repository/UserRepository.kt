package jonisor.composenavigation.core.data.repository

import android.util.Log
import jonisor.composenavigation.core.data.model.User
import jonisor.composenavigation.core.data.service.UserService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepository @Inject constructor(
    private val userService: UserService
) {
    suspend fun getUsers(): List<User>? {
        return try {
            userService.getAllUsers()

        } catch (e: Exception) {
            e.message?.let { Log.d("TESTING", it) }
            return null
        }
    }

    suspend fun getUser(id: String): User? {
        return userService.getUser(id)
    }

    suspend fun addUser(user: User): List<User> {
        return userService.addUser(user)
    }
}
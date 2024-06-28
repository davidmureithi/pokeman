package home.pokeman.authentication.model

import home.pokeman.authentication.data.AuthUser
import kotlinx.coroutines.flow.Flow

interface AuthRepository {
    fun signIn(
        username: String,
        password: String,
    )

    fun signUp(
        username: String,
        password: String,
    )

    suspend fun addUser(user: AuthUser): Flow<AuthNetworkState<String>>

    suspend fun updateUser(user: AuthUser): Flow<AuthNetworkState<String>>

    suspend fun deleteUser(user: AuthUser): Flow<AuthNetworkState<String>>

    suspend fun fetchAllUsers(): Flow<AuthNetworkState<List<AuthUser>>>
}

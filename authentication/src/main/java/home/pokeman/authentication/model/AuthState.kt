package home.pokeman.authentication.model

import home.pokeman.authentication.data.AuthUser

data class AuthState(
    val data: List<AuthUser>? = null,
    val isLoading: Boolean = false,
    val errorMsg: String? = null,
)

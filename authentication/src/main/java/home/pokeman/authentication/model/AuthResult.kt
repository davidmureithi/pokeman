package home.pokeman.authentication.model

sealed class AuthResult<out R> {
    data class Success<out T>(val data: T) : AuthResult<T>()

    data class Error(val throwable: Throwable) : AuthResult<Nothing>()

    object Loading : AuthResult<Nothing>()
}

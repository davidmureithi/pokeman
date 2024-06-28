package home.pokeman.authentication.model

sealed class AuthNetworkState<out R> {
    data class Success<out T>(val data: T) : AuthNetworkState<T>()

    data class Error(val throwable: Throwable) : AuthNetworkState<Nothing>()

    object Loading : AuthNetworkState<Nothing>()
}

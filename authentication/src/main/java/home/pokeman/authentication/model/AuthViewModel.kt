package home.pokeman.authentication.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import home.pokeman.authentication.data.AuthUser
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

//@HiltViewModel
class AuthViewModel(
        private val authRepository: AuthRepository
    ) : ViewModel() {
        private val _authState = MutableStateFlow(AuthState())
        val authState: StateFlow<AuthState> = _authState.asStateFlow()

        init {
            fetchAllUsers()
        }

        fun addUser(user: AuthUser) {
            viewModelScope.launch {
                authRepository.addUser(user).collect { result ->
                    when (result) {
                        is AuthNetworkState.Success -> {
//                             Toast.makeText(context, result.data, Toast.LENGTH_LONG).show()
                        }
                        is AuthNetworkState.Error -> {
//                             Toast.makeText(context, result.throwable.toString(), Toast.LENGTH_LONG).show()
                        }
                        is AuthNetworkState.Loading -> {
//                             Toast.makeText(context, "Loading", Toast.LENGTH_LONG).show()
                        }
                    }
                }
            }
        }

        fun updateUser(user: AuthUser) {
            viewModelScope.launch {
                authRepository.updateUser(user).collect { result ->
                    when (result) {
                        is AuthNetworkState.Success -> {
//                            Toast.makeText(context, result.data, Toast.LENGTH_LONG).show()
                        }
                        is AuthNetworkState.Error -> {
//                            Toast.makeText(context, result.throwable.toString(), Toast.LENGTH_LONG).show()
                        }
                        is AuthNetworkState.Loading -> {
//                            Toast.makeText(context, "Loading", Toast.LENGTH_LONG).show()
                        }
                    }
                }
            }
        }

        fun deleteUser(user: AuthUser) {
            viewModelScope.launch {
                authRepository.deleteUser(user).collect { result ->
                    when (result) {
                        is AuthNetworkState.Success -> {
//                            Toast.makeText(context, result.data, Toast.LENGTH_LONG).show()
                        }
                        is AuthNetworkState.Error -> {
//                            Toast.makeText(context, result.throwable.toString(), Toast.LENGTH_LONG).show()
                        }
                        is AuthNetworkState.Loading -> {
//                            Toast.makeText(context, "Loading", Toast.LENGTH_LONG).show()
                        }
                    }
                }
            }
        }

        fun fetchAllUsers() {
            viewModelScope.launch {
                authRepository.fetchAllUsers().collect { result ->
                    when (result) {
                        is AuthNetworkState.Success -> {
                            _authState.update {
                                it.copy(data = result.data, isLoading = false, errorMsg = null)
                            }
                        }
                        is AuthNetworkState.Error -> {
                            _authState.update {
                                it.copy(data = null, isLoading = false, errorMsg = result.throwable.message)
                            }
                        }
                        is AuthNetworkState.Loading -> {
                            _authState.update {
                                it.copy(data = null, isLoading = true, errorMsg = null)
                            }
                        }
                    }
                }
            }
        }

        fun signIn(
            username: String,
            password: String,
        ) = authRepository.signIn(username, password)

        fun signUp(
            username: String,
            password: String,
        ) = authRepository.signUp(username, password)
    }

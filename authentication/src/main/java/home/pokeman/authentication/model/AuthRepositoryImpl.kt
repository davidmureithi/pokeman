package home.pokeman.authentication.model

import home.pokeman.authentication.data.AuthUser
import home.pokeman.authentication.data.AuthUserDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(private val authUserDao: AuthUserDao) : AuthRepository {
	override suspend fun addUser(user: AuthUser): Flow<AuthNetworkState<String>> =
		flow {
			emit(AuthNetworkState.Loading)
			try {
				authUserDao.addUser(user)
				emit(AuthNetworkState.Success("User Added"))
			} catch (exception: Exception) {
				emit(AuthNetworkState.Error(Throwable(exception.message)))
			}
		}.flowOn(Dispatchers.IO)
	
	override suspend fun updateUser(user: AuthUser): Flow<AuthNetworkState<String>> =
		flow {
			emit(AuthNetworkState.Loading)
			try {
				authUserDao.updateUser(user)
				emit(AuthNetworkState.Success("User Updated"))
			} catch (exception: Exception) {
				emit(AuthNetworkState.Error(Throwable(exception.message)))
			}
		}.flowOn(Dispatchers.IO)
	
	override suspend fun deleteUser(user: AuthUser): Flow<AuthNetworkState<String>> =
		flow {
			emit(AuthNetworkState.Loading)
			try {
				authUserDao.deleteUser(user)
				emit(AuthNetworkState.Success("User Deleted"))
			} catch (exception: Exception) {
				emit(AuthNetworkState.Error(Throwable(exception.message)))
			}
		}.flowOn(Dispatchers.IO)
	
	override suspend fun fetchAllUsers(): Flow<AuthNetworkState<List<AuthUser>>> =
		callbackFlow {
			authUserDao.fetchAllUsers().onStart {
				trySend(AuthNetworkState.Loading)
			}.catch { exception ->
				trySend(AuthNetworkState.Error(Throwable(exception.message)))
			}.collectLatest { list ->
				trySend(AuthNetworkState.Success(list))
			}
			awaitClose { close() }
		}.flowOn(Dispatchers.IO)
	
	override fun signIn(
		username: String,
		password: String,
	) {
		TODO("Not yet implemented")
	}
	
	override fun signUp(
		username: String,
		password: String,
	) {
		TODO("Not yet implemented")
	}
}

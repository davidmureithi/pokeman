package home.pokeman.data.repository

import home.pokeman.data.dataSource.PokeManDataSourceImpl
import home.pokeman.data.model.PokeManResponse
import home.pokeman.utilities.ResourceState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class PokeManRepository @Inject constructor(private val pokeManDataSource: PokeManDataSourceImpl) {
	
	suspend fun fetchNewsHeadline(limit: String): Flow<ResourceState<PokeManResponse>> {
		return flow {
			emit(ResourceState.Loading())
			
			val response = pokeManDataSource.fetchPokeManList(limit)
			
			if (response.isSuccessful && response.body() != null) {
				emit(ResourceState.Success(response.body()!!))
			} else {
				emit(ResourceState.Error("An error occurred!"))
			}
		}.catch { exception ->
			emit(ResourceState.Error(exception.localizedMessage ?: "An error occurred!"))
		}
	}
}
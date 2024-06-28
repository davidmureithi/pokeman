package home.pokeman.data.dataSource

import home.pokeman.data.api.ApiService
import home.pokeman.data.model.PokeManResponse
import retrofit2.Response
import javax.inject.Inject

class PokeManDataSourceImpl @Inject constructor(private val apiService: ApiService) : PokeManDataSource {
	override suspend fun fetchPokeManList(limit: String): Response<PokeManResponse> {
		return apiService.fetchPokeManList()
	}
}
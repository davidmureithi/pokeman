package home.pokeman.data.dataSource

import home.pokeman.data.model.PokeManResponse
import retrofit2.Response

interface PokeManDataSource {
	suspend fun fetchPokeManList(limit: String): Response<PokeManResponse>
}
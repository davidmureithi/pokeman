package home.pokeman.data.api

import home.pokeman.data.model.PokeManResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
	
	@GET("api/v2/pokemon?limit=100&offset=100")
	suspend fun fetchPokeManList(): Response<PokeManResponse>
}
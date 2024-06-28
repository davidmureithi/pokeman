package home.pokeman.data.model

data class PokeManResponse(
	val count: Int = 0,
	val next: String = "",
	val previous: String = "",
	val results: List<Results>
)

data class Results(
	val name : String = "",
	val url : String = ""
)
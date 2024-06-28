package home.pokeman.ui.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import home.pokeman.data.model.PokeManResponse
import home.pokeman.ui.components.TextComponent


@Composable
fun PokeManListScreen(response: PokeManResponse) {
	LazyColumn {
		items(response.results) {
			TextComponent(text = it.name)
		}
	}
}
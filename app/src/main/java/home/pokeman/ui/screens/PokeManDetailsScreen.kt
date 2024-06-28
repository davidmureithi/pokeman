package home.pokeman.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import home.pokeman.ui.components.TextComponent
import home.pokeman.ui.components.TopBar

@Composable
fun DetailsScreen(name: String, url: String) {
	Surface(
		modifier = Modifier.fillMaxSize(),
		color = Color.White
	) {
		Column(
			modifier = Modifier
				.fillMaxSize()
				.padding(16.dp)
		) {
			TopBar(title = "Hi $name!")
			Spacer(modifier = Modifier.size(60.dp))
			TextComponent(text = url, textSize = 24.sp)
			Spacer(modifier = Modifier.size(60.dp))
		}
	}
}

@Preview(showBackground = true)
@Composable
fun DetailsScreenPreview() {
	DetailsScreen(name = "Don", url = "https://pokeapi.co/")
}
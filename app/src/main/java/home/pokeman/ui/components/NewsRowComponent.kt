package home.pokeman.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import home.pokeman.R
import home.pokeman.data.model.Results

@Composable
fun NewsRowComponent(page: Int, articles: Results) {
	
	Column(
		modifier = Modifier
			.fillMaxSize()
			.padding(8.dp)
			.background(Color.White),
	) {
		AsyncImage(
			modifier = Modifier
				.fillMaxWidth()
				.height(240.dp),
			model = articles.url,
			contentDescription = "",
			contentScale = ContentScale.Crop,
			placeholder = painterResource(id = R.drawable.ic_cat),
			error = painterResource(id = R.drawable.ic_cat)
		)
		Spacer(modifier = Modifier.size(20.dp))
		TextComponent(text = "$page \n\n ${articles.name} ")
		
	}
}

@Preview
@Composable
fun NewsRowComponentScreen() {
	val article = Results(name = "David", url = "")
	NewsRowComponent(page = 0, articles = article)
}
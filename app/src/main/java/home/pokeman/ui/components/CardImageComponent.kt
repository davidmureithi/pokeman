package home.pokeman.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import home.pokeman.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardImage(
	imageValue: Int,
	selected: Boolean = false,
	onCardSelected: (String) -> Unit = {}
) {
	val localFocusManager = LocalFocusManager.current

	Card(
		onClick = {
			val imageSelected = if (imageValue == R.drawable.ic_dog) "Dog" else "Cat"
			onCardSelected(imageSelected)
			localFocusManager.clearFocus()
		},
		shape = RoundedCornerShape(8.dp),
		modifier = Modifier
			.padding(16.dp)
			.size(130.dp),
		elevation = CardDefaults.cardElevation(5.dp)
	) {
		Box(
			modifier = Modifier
				.fillMaxWidth()
				.border(
					width = 1.dp,
					color = if (selected) Color.Green else Color.Transparent,
					shape = RoundedCornerShape(8.dp)
				)
		) {
			Image(
				modifier = Modifier
					.padding(16.dp)
					.wrapContentHeight()
					.wrapContentWidth(),
				painter = painterResource(id = imageValue), contentDescription = "Image"
			)
		}
	}
}

@Preview
@Composable
fun CardImagePreview() {
	CardImage(imageValue = R.drawable.ic_cat)
}
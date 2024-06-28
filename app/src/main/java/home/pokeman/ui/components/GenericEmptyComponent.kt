package home.pokeman.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import home.pokeman.R

@Composable
fun GenericEmptyComponent() {
	Column(modifier = Modifier.fillMaxWidth()) {
		val painter = rememberAsyncImagePainter(
			model = ImageRequest
				.Builder(LocalContext.current)
				.data(data = R.drawable.ic_cat)
				.apply {
				
				}.build()
		)
		Image(painter = painter, contentDescription = "")
		TitleTextComponent(text = "Title")
		TextComponent(text = "Desc")
		ButtonComponent(
			text = "Click",
			onClickCallback = {}
		)
	}
}

@Preview
@Composable
fun GenericEmptyComponentPreview() {
	GenericEmptyComponent()
}
package home.pokeman.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ButtonComponent(
	text: String,
	onClickCallback: () -> Unit
) {
	Button(
		onClick = { onClickCallback() },
		modifier = Modifier.fillMaxWidth()
	) {
		TextComponent(text = text, colorValue = Color.White)
	}
}

@Preview
@Composable
fun ButtonComponentPreview(){
	ButtonComponent("Click") {}
}
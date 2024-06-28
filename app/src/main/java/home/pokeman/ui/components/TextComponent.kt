package home.pokeman.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TextComponent(
	modifier: Modifier = Modifier,
	text: String
) {
	Text(
		modifier = modifier
			.wrapContentWidth()
			.wrapContentHeight(),
		text = text,
		style = TextStyle(
			fontWeight = FontWeight.Normal,
			fontSize = 14.sp
		)
	)
}

@Composable
fun TextComponent(
	modifier: Modifier = Modifier,
	text: String,
	colorValue: Color = Color.Black,
	textSize: TextUnit = 14.sp
) {
	Text(
		modifier = modifier
			.wrapContentHeight()
			.wrapContentWidth(),
		text = text,
		color = colorValue,
		fontSize = textSize,
		fontWeight = FontWeight.Light
	)
}

@Composable
@Preview(showBackground = true)
fun TextComponentPreview() {
	TextComponent(text = "textValue")
}

@Composable
fun TitleTextComponent(
	modifier: Modifier = Modifier,
	text: String
) {
	Text(
		modifier = modifier
			.fillMaxWidth()
			.wrapContentHeight(),
		text = text,
		style = TextStyle(
			fontFamily = FontFamily.Monospace,
			fontWeight = FontWeight.Normal,
			fontSize = 14.sp,
			fontStyle = FontStyle.Normal,
			color = Color.Black
		)
	)
}

@Preview
@Composable
fun TitleTextComponentPreview() {
	TitleTextComponent(text = "Text")
}

@Composable
fun DescriptionComponent(
	modifier: Modifier = Modifier,
	text: String
) {
	Text(
		modifier = modifier
			.fillMaxWidth()
			.wrapContentHeight(),
		text = text,
		style = TextStyle(
			fontFamily = FontFamily.Monospace,
			fontWeight = FontWeight.Normal,
			fontSize = 14.sp,
			fontStyle = FontStyle.Normal,
			color = Color.Black
		)
	)
}

@Preview
@Composable
fun DescriptionComponentPreview() {
	TitleTextComponent(text = "Text")
}

@Composable
fun SmallTextComponent(
	modifier: Modifier = Modifier,
	text: String
) {
	Text(
		modifier = modifier
			.fillMaxWidth()
			.wrapContentHeight()
			.padding(2.dp),
		text = text,
		style = TextStyle(
			fontWeight = FontWeight.Normal,
			fontSize = 8.sp
		)
	)
}

@Preview
@Composable
fun SmallTextComponentPreview() {
	SmallTextComponent(text = "Text")
}

@Composable
fun RatingTextComponent(text: String) {
	Text(
		text = text,
		fontWeight = Bold,
		modifier = Modifier
			.background(Color.Green)
			.padding(3.dp),
		style = TextStyle(
			fontSize = 8.sp,
			fontStyle = FontStyle.Normal,
			fontWeight = FontWeight(16),
			textAlign = TextAlign.Center
		)
	)
}

@Preview
@Composable
fun RatingTextComponentPreview() {
	RatingTextComponent(text = "Text")
}

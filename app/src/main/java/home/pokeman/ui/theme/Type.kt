package home.pokeman.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

// Set of Material typography styles to start with
val Typography =
	Typography(
		bodyLarge =
		TextStyle(
			fontFamily = FontFamily.Default,
			fontWeight = FontWeight.Normal,
			fontSize = 16.sp,
			lineHeight = 24.sp,
			letterSpacing = 0.5.sp,
		),
	)

val textTitle =
	TextStyle(
		fontFamily = FontFamily.Default,
		fontWeight = FontWeight.Light,
		fontSize = 48.sp,
		textAlign = TextAlign.Center,
	)

fun textDescription() =
	TextStyle(
		fontFamily = FontFamily.Default,
		fontWeight = FontWeight.Light,
		fontSize = 48.sp,
		textAlign = TextAlign.Center,
	)

fun dropdownText(color: Color) =
	TextStyle(
		fontFamily = FontFamily.Default,
		fontWeight = FontWeight.Normal,
		fontSize = 32.sp,
		textAlign = TextAlign.Center,
		color = color,
	)
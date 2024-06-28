package home.pokeman.ui.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import home.pokeman.Utils

@Composable
fun TextWithShadow(value: String) {
	val colorOffset = Offset(1f, 2f)
	Text(
		text = value, fontSize = 24.sp, fontWeight = FontWeight.Medium, style = TextStyle(
			shadow = Shadow(
				color = Utils.generateRandomColor(), offset = colorOffset, blurRadius = 2f
			)
		)
	)
}
package home.pokeman.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import home.pokeman.R

@Composable
fun TopBar(
	modifier: Modifier = Modifier,
	title: String
) {
	Row(
		modifier = modifier
			.fillMaxWidth(),
		verticalAlignment = Alignment.CenterVertically
	) {
		Text(
			text = title,
			fontSize = 24.sp,
			color = Color.Black,
			fontWeight = FontWeight.Medium
		)
		Spacer(modifier = Modifier.weight(1f))
		Image(
			modifier = Modifier
				.size(40.dp)
				.padding(5.dp),
			painter = painterResource(id = R.drawable.ic_cat),
			contentDescription = ""
		)
	}
}

@Preview(showBackground = true)
@Composable
fun TopBarPreview() {
	TopBar(title = "Hi there :)")
}
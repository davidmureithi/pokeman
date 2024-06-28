package home.pokeman.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import home.pokeman.R

@Composable
fun FactCardComponent(value: String) {
	Card(
		modifier = Modifier
			.fillMaxWidth()
			.padding(16.dp),
		elevation = CardDefaults.cardElevation(5.dp),
		shape = RoundedCornerShape(8.dp)
	) {
		Column(modifier = Modifier.padding(18.dp, 24.dp)) {
			Image(
				painter = painterResource(id = R.drawable.ic_quote),
				contentDescription = "Quote Open",
				modifier = Modifier.rotate(180f)
			)
			Spacer(modifier = Modifier.size(24.dp))
			TextWithShadow(value = value)
			Spacer(modifier = Modifier.size(24.dp))
			Image(painter = painterResource(id = R.drawable.ic_quote), contentDescription = "Quote Close")
		}
	}
}
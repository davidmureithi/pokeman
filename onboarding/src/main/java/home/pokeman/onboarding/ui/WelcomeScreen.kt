package home.pokeman.onboarding.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import home.pokeman.onboarding.R
import home.pokeman.onboarding.ui.theme.textDescription
import home.pokeman.onboarding.ui.theme.textTitle

@Composable
fun WelcomeScreen(
    image: Painter,
    title: String = "",
    description: String = "",
    onButtonClicked: () -> Unit = {},
) {
    Column(
        modifier =
            Modifier
                .fillMaxSize()
                .padding(16.dp),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            modifier = Modifier.size(150.dp),
            painter = image,
            contentDescription = stringResource(id = R.string.splash_screen_image),
        )
        Text(text = title, style = textTitle)
        Text(text = description, style = textDescription())
        Button(onClick = { onButtonClicked() }) {
            Text(text = "Continue")
        }
    }
}

@Preview(showBackground = true, name = "Splash Screen")
@Composable
fun WelcomeScreenPreview() {
    WelcomeScreen(
        image = painterResource(id = R.drawable.ic_cat),
        title = stringResource(id = R.string.app_name),
        description = stringResource(id = R.string.splash_description),
    )
}

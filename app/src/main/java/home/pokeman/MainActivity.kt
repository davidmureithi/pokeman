package home.pokeman

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import dagger.hilt.android.AndroidEntryPoint
import home.pokeman.ui.navigation.NavigationGraph
import home.pokeman.ui.theme.PokeManTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
	@RequiresApi(Build.VERSION_CODES.S)
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		installSplashScreen()
		setContent {
			PokeManTheme {
				Surface(
					modifier = Modifier.fillMaxSize(), color = Color.White
				) {
					PokeMan()
				}
			}
		}
	}
}

@RequiresApi(Build.VERSION_CODES.S)
@Composable
fun PokeMan() {
	NavigationGraph()
}

@RequiresApi(Build.VERSION_CODES.S)
@Preview
@Composable
fun PokeManPreview() {
	PokeMan()
}
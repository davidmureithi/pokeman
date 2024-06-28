package home.pokeman.onboarding

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import dagger.hilt.android.AndroidEntryPoint
import home.pokeman.authentication.AuthActivity
import home.pokeman.onboarding.ui.OnBoardingScreen
import home.pokeman.onboarding.ui.theme.PokeManTheme

@AndroidEntryPoint
class OnBoardingActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PokeManTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    var shouldShowWelcomeScreen by remember { mutableStateOf(true) }
                    
                    if (shouldShowWelcomeScreen) { // Check if its first access then show welcome screen else show auth straight up
                        OnBoardingScreen(modifier = Modifier.fillMaxSize())
                    } else {
                        startActivity(Intent(this, AuthActivity::class.java))
                    }
                }
            }
        }
    }
}
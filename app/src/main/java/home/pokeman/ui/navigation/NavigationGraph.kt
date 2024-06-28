package home.pokeman.ui.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import home.pokeman.ui.screens.HomeScreen

@RequiresApi(Build.VERSION_CODES.S)
@Composable
fun NavigationGraph() {
	
	val navController = rememberNavController()
	
	NavHost(navController = navController, startDestination = Routes.HOME_SCREEN) {
		composable(Routes.HOME_SCREEN) {
			HomeScreen()
		}

		composable(Routes.DETAILS_SCREEN) {
		}
	}
}
package home.pokeman.onboarding.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import home.pokeman.onboarding.R
import home.pokeman.onboarding.data.welcomeScreenData
import home.pokeman.onboarding.ui.theme.PokeManTheme
import home.pokeman.onboarding.ui.theme.Purple40
import home.pokeman.onboarding.ui.theme.Purple80

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnBoardingScreen(modifier: Modifier = Modifier) {
	val pagerState = rememberPagerState(pageCount = { welcomeScreenData().size })
	HorizontalPager(
		modifier = modifier.padding(16.dp),
		state = pagerState,
	) {
		repeat(pagerState.pageCount) {
			WelcomeScreen(
				image = painterResource(id = R.drawable.ic_cat),
				title = "Hello Food",
				description = "Desc",
			) {
                //shouldShowWelcomeScreen = false
            }
		}
	}
	
	Row(
        Modifier
            .wrapContentHeight()
            .fillMaxWidth()
            .padding(8.dp),
		horizontalArrangement = Arrangement.Center,
	) {
		repeat(pagerState.pageCount) { iteration ->
			val color = if (pagerState.currentPage == iteration) Purple80 else Purple40
			Box(
				modifier =
                Modifier
                    .padding(2.dp)
                    .clip(CircleShape)
                    .background(color)
                    .size(16.dp),
			)
		}
	}
}


@Preview(showBackground = true)
@Composable
fun MyAppPreview() {
	PokeManTheme {
		OnBoardingScreen()
	}
}
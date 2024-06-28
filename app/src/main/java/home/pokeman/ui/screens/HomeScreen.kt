package home.pokeman.ui.screens

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import home.pokeman.ui.components.NewsRowComponent
import home.pokeman.ui.components.ProgressLoader
import home.pokeman.ui.viewmodel.PokeManViewModel
import home.pokeman.utilities.ResourceState

const val TAG = "HomeScreen"
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(pokeManViewModel: PokeManViewModel = hiltViewModel()) {

	val newsResponse by pokeManViewModel.pokeManList.collectAsState()
	val pagerState = rememberPagerState(
		initialPage = 0,
		initialPageOffsetFraction = 0f
	) {
		100
	}
	
	VerticalPager(state = pagerState,
		modifier = Modifier.fillMaxSize(),
		pageSize = PageSize.Fill,
		pageSpacing = 8.dp
	) {page: Int ->
		when(newsResponse) {
			is ResourceState.Loading -> {
				Log.d(TAG, "ResourceState.Loading")
				ProgressLoader()
			}
			is ResourceState.Success -> {
				val response = (newsResponse as ResourceState.Success).data
				Log.d(TAG, "ResourceState.Success")
				NewsRowComponent(page, response.results[page])
				
			}
			is ResourceState.Error -> {
				Log.d(TAG, "ResourceState.Error")
			}
		}
	}
}

@Preview
@Composable
fun HomeScreenPreview() {
	HomeScreen()
}
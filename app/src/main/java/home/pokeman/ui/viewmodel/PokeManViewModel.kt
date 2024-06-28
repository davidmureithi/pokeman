package home.pokeman.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import home.pokeman.AppConstants
import home.pokeman.data.model.PokeManResponse
import home.pokeman.data.repository.PokeManRepository
import home.pokeman.utilities.ResourceState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokeManViewModel @Inject constructor(private val pokeManRepository: PokeManRepository) : ViewModel() {

	private var _pokeManList = MutableStateFlow<ResourceState<PokeManResponse>>(ResourceState.Loading())
	val pokeManList: StateFlow<ResourceState<PokeManResponse>> = _pokeManList
	
	init {
		fetchPokeManList(AppConstants.LIMIT)
	}
	
	private fun fetchPokeManList(limit: String) {
		viewModelScope.launch(Dispatchers.IO) {
			pokeManRepository.fetchNewsHeadline(limit).collectLatest { newsResponse ->
				_pokeManList.value = newsResponse
			}
		}
	}
}
package jonisor.composenavigation.feature.latest.ui.viewmodel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import androidx.lifecycle.viewModelScope
import jonisor.composenavigation.core.data.model.ArtistAd
import jonisor.composenavigation.core.data.repository.AdRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

data class LatestUiState(
    val artistsAds: List<ArtistAd>? = emptyList()
)

@HiltViewModel
class LatestViewModel @Inject constructor(
    private val adRepository: AdRepository
): ViewModel() {
    private val _uiState = MutableStateFlow(LatestUiState())
    val uiState: StateFlow<LatestUiState> = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            val artistsAds = adRepository.getArtistsAds()

            _uiState.update {
                it.copy(
                    artistsAds = artistsAds
                )
            }
        }
    }
    /*
    fun addUser() {
        viewModelScope.launch {
            val randomId = java.util.UUID.randomUUID().toString()
            val user = User(id = randomId, name = "New User" )

            userRepository.addUser(user)
        }
    }
    */
}
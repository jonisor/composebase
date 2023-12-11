package jonisor.composenavigation.feature.latest.ui.viewmodel

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import jonisor.composenavigation.core.data.model.Artist
import jonisor.composenavigation.core.data.model.ArtistAd
import jonisor.composenavigation.core.data.repository.AdRepository
import jonisor.composenavigation.core.data.repository.ArtistRepository
import jonisor.composenavigation.feature.latest.ui.screen.destinations.ArtistAdScreenDestination
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

data class ArtistAdScreenUiState(
    val ad: ArtistAd? = null,
    val artist: Artist? = null
)

@HiltViewModel
class ArtistAdScreenViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val adRepository: AdRepository,
    private val artistRepository: ArtistRepository
): ViewModel() {
    private val navArgs =
        ArtistAdScreenDestination.argsFrom(savedStateHandle).id

    private val _uiState = MutableStateFlow(ArtistAdScreenUiState())
    val uiState: StateFlow<ArtistAdScreenUiState> = _uiState.asStateFlow()

    init {
        getAd()
    }

    private fun getAd() {
        viewModelScope.launch {
            val artistAd = adRepository.getArtistsAd(navArgs)

            artistAd?.let {
                _uiState.update { currentState ->
                    currentState.copy(
                        ad = artistAd
                    ).apply {
                        getArtist(artistAd.artistId)
                    }
                }
            }
        }
    }

    private fun getArtist(id: String) {
        viewModelScope.launch {
            val artist = artistRepository.getArtist(id)

            artist?.let {
                _uiState.update { currentState ->
                    currentState.copy(
                        artist = artist
                    )
                }
            }
        }
    }
}
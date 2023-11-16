package jonisor.composenavigation.feature.latest.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import jonisor.composenavigation.core.data.repository.TestRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

@HiltViewModel
class LatestViewModel @Inject constructor(
    private val testRepository: TestRepository
): ViewModel() {

    fun initialise() {
        viewModelScope.launch {
            val temp = testRepository.getTest()
            Log.d("TESTING", temp.toString())
        }
    }
}
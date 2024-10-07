package ua.czrblz.nitrix_soft_test_task

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import ua.czrblz.domain.model.VideoModel
import ua.czrblz.domain.usecase.GetVideosFromDBUseCase
import ua.czrblz.domain.usecase.GetVideosFromServerUseCase
import ua.czrblz.domain.usecase.GetVideosUrlUseCase
import ua.czrblz.domain.usecase.SaveVideosInfoToDBUseCase

class MainViewModel(
    private val getVideosFromDBUseCase: GetVideosFromDBUseCase,
    private val getVideosFromServerUseCase: GetVideosFromServerUseCase,
    private val saveVideosInfoToDBUseCase: SaveVideosInfoToDBUseCase,
    private val getVideosUrlUseCase: GetVideosUrlUseCase
): ViewModel() {

    private val _data = MutableStateFlow<List<VideoModel>>(listOf())
    val data: StateFlow<List<VideoModel>> = _data

    private val _urls = MutableStateFlow<List<String>>(listOf())
    val urls: StateFlow<List<String>> = _urls

    private val _errorMessage = MutableStateFlow<String?>(null)
    val errorMessage: StateFlow<String?> = _errorMessage.asStateFlow()

    init {
        viewModelScope.launch {
            getVideosFromServerUseCase()
                .onSuccess { videoList ->
                    saveVideosInfoToDBUseCase(videoList)
                }
                .onFailure { throwable ->
                    _errorMessage.value = throwable.message
                    _errorMessage.value = null
                }
        }

        viewModelScope.launch {
            getVideosFromDBUseCase().collectLatest {
                _data.value =  it
                _urls.value = getVideosUrlUseCase(it)
            }
        }
    }
}
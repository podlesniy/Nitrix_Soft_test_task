package ua.czrblz.nitrix_soft_test_task.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import ua.czrblz.nitrix_soft_test_task.MainViewModel
import ua.czrblz.nitrix_soft_test_task.view.ExoPlayerView
import ua.czrblz.nitrix_soft_test_task.view.TopBar
import ua.czrblz.nitrix_soft_test_task.view.VideoCard

@Composable
fun MainScreen(
    viewModel: MainViewModel
) {
    val videoList by viewModel.data.collectAsState()
    val videoUrlList by viewModel.urls.collectAsState()
    var startVideo by remember { mutableStateOf(false) }
    var startVideoIndex by remember { mutableIntStateOf(0) }

    Scaffold(
        modifier = Modifier.statusBarsPadding().fillMaxSize(),
        containerColor = Color.White,
        topBar = {
            TopBar()
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier.padding(innerPadding)
        ) {
            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
                itemsIndexed(videoList) { index, vm ->
                    VideoCard(vm) {
                        startVideo = true
                        startVideoIndex = index
                    }
                }
            }
            if (startVideo) {
                ExoPlayerView(videoUrlList, startVideoIndex) {
                    startVideo = false
                }
            }
        }
    }
}
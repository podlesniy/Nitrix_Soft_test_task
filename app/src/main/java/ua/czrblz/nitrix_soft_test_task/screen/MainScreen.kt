package ua.czrblz.nitrix_soft_test_task.screen

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import ua.czrblz.network.utils.isNetworkAvailable
import ua.czrblz.nitrix_soft_test_task.MainViewModel
import ua.czrblz.nitrix_soft_test_task.R
import ua.czrblz.nitrix_soft_test_task.view.EmptyView
import ua.czrblz.nitrix_soft_test_task.view.ExoPlayerView
import ua.czrblz.nitrix_soft_test_task.view.TopBar
import ua.czrblz.nitrix_soft_test_task.view.VideoCard

@Composable
fun MainScreen(
    viewModel: MainViewModel
) {
    val context = LocalContext.current
    val videoList by viewModel.data.collectAsState()
    val videoUrlList by viewModel.urls.collectAsState()
    val error by viewModel.errorMessage.collectAsState()
    var startVideo by rememberSaveable { mutableStateOf(false) }
    var startVideoIndex by rememberSaveable { mutableIntStateOf(0) }

    LaunchedEffect(error) {
        error?.let {
            Toast.makeText(context, context.getText(R.string.server_error), Toast.LENGTH_SHORT).show()
        }
    }

    Scaffold(
        modifier = Modifier
            .statusBarsPadding()
            .fillMaxSize(),
        containerColor = Color.White,
        topBar = {
            TopBar() {
                viewModel.getVideos()
            }
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier.padding(innerPadding)
        ) {
            if (videoList.isEmpty()) {
                EmptyView(
                    Modifier.fillMaxSize()
                )
            } else {
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
            }
        }
    }
    if (startVideo) {
        isNetworkAvailable(context).takeIf { it }?.let {
            ExoPlayerView(videoUrlList, startVideoIndex) {
                startVideo = false
            }
        }?: run {
            Toast.makeText(context, context.getText(R.string.video_error), Toast.LENGTH_SHORT).show()
            startVideo = false
        }
    }
}
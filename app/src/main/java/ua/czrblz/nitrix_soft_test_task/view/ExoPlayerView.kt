package ua.czrblz.nitrix_soft_test_task.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import androidx.media3.common.MediaItem
import androidx.media3.common.util.UnstableApi
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView

@androidx.annotation.OptIn(UnstableApi::class)
@Composable
fun ExoPlayerView() {
    val context = LocalContext.current

    val exoPlayer = ExoPlayer.Builder(context)
        .build()

    val video = "https://www.hdclub.ua/files/avpedia_test/tron_legacy_trailer.mp4"
    val mediaSource = remember(video) { MediaItem.fromUri(video) }

    LaunchedEffect(mediaSource) {
        exoPlayer.setMediaItem(mediaSource)
        exoPlayer.prepare()
        exoPlayer.playWhenReady = true
    }

    DisposableEffect(Unit) {
        onDispose {
            exoPlayer.release()
        }
    }

    Box(modifier = Modifier.fillMaxSize()) {
        AndroidView(
            factory = { ctx ->
                PlayerView(ctx).apply {
                    player = exoPlayer
                    setShowFastForwardButton(false)
                    setShowRewindButton(false)
                    setShowPreviousButton(false)
                    setShowNextButton(false)
                    setShowVrButton(false)
                    setShowPlayButtonIfPlaybackIsSuppressed(false)
                }
            },
            modifier = Modifier.fillMaxSize()
        )
    }
}
package ua.czrblz.nitrix_soft_test_task.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.media3.common.MediaItem
import androidx.media3.common.util.UnstableApi
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.exoplayer.source.ConcatenatingMediaSource
import androidx.media3.exoplayer.source.DefaultMediaSourceFactory
import androidx.media3.ui.PlayerView
import ua.czrblz.nitrix_soft_test_task.R

@androidx.annotation.OptIn(UnstableApi::class)
@Composable
fun ExoPlayerView(
    videoList: List<String>,
    startVideoIndex: Int,
    onCloseClick: () -> Unit
) {
    val context = LocalContext.current

    val exoPlayer = ExoPlayer.Builder(context)
        .build()

    val mediaItems: ArrayList<MediaItem> = ArrayList()
    videoList.forEach {
        mediaItems.add(MediaItem.fromUri(it))
    }
    val mediaSourceFactory = DefaultMediaSourceFactory(context)
    val mediaSource = ConcatenatingMediaSource().apply {
        mediaItems.forEach {
            addMediaSource(mediaSourceFactory.createMediaSource(it))
        }
    }

    LaunchedEffect(mediaSource) {
        exoPlayer.setMediaSource(mediaSource)
        exoPlayer.prepare()
        exoPlayer.playWhenReady = true
    }

    DisposableEffect(Unit) {
        onDispose {
            exoPlayer.release()
        }
    }

    Box(modifier = Modifier.fillMaxSize().background(Color.White)) {
        AndroidView(
            factory = { ctx ->
                PlayerView(ctx).apply {
                    player = exoPlayer
                    setShowFastForwardButton(false)
                    setShowRewindButton(false)
                    setShowPreviousButton(true)
                    setShowNextButton(true)
                    setShowVrButton(false)
                    setShowPlayButtonIfPlaybackIsSuppressed(false)
                }
            },
            modifier = Modifier.fillMaxSize()
        )
        Button(
            onClick = onCloseClick,
            modifier = Modifier
                .align(Alignment.TopEnd),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent
            )
        ) {
            Image(
                imageVector = ImageVector.vectorResource(R.drawable.ic_close),
                modifier = Modifier
                    .background(Color.White, RoundedCornerShape(12.dp)),
                contentDescription = null
            )
        }
    }
}
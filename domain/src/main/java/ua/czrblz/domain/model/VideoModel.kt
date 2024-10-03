package ua.czrblz.domain.model

data class VideoModel(
    val id: Int,
    val title: String,
    val duration: Int,
    val videoUrl: String,
    val videoThumbnail: String,
    val likes: Int
)
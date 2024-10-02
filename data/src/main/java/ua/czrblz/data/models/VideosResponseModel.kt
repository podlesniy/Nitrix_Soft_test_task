package ua.czrblz.data.models

data class VideosResponseModel(
    val hits: List<Video>
)

data class Video(
    val id: Int,
    val tags: String,
    val duration: Int,
    val videos: VideoFormats,
    val likes: Int
)

data class VideoFormats(
    val tiny: VideoDetails
)

data class VideoDetails(
    val url: String,
    val thumbnail: String
)
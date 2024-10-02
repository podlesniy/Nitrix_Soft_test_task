package ua.czrblz.nitrix_soft_test_task.api.models

data class MoviesModel(
    val hits: List<Video>
)

data class Video(
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
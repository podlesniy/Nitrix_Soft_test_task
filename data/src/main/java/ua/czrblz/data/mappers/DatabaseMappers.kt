package ua.czrblz.data.mappers

import ua.czrblz.data.models.VideoDBModel
import ua.czrblz.domain.model.VideoModel

class DatabaseMappers {

    fun toVideoModel(list: List<VideoDBModel>): List<VideoModel> = list.map {
        VideoModel(
            id = it.id,
            title = it.title,
            duration = it.duration,
            videoUrl = it.videoUrl,
            videoThumbnail = it.videoThumbnail,
            likes = it.likes
        )
    }

    fun toVideoDBModel(list: List<VideoModel>): List<VideoDBModel> = list.map {
        VideoDBModel(
            id = it.id,
            title = it.title,
            duration = it.duration,
            videoUrl = it.videoUrl,
            videoThumbnail = it.videoThumbnail,
            likes = it.likes
        )
    }
}

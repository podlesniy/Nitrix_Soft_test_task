package ua.czrblz.data.mappers

import ua.czrblz.data.models.Video
import ua.czrblz.domain.model.VideoModel

class VideoMappers {

    fun toVideoModel(list: List<Video>): List<VideoModel> {
        val arrayList: ArrayList<VideoModel> = ArrayList()
        list.forEach {
            arrayList.add(
                VideoModel(
                    id = it.id,
                    title = it.tags,
                    duration = it.duration,
                    videoUrl = it.videos.tiny.url,
                    videoThumbnail = it.videos.tiny.thumbnail,
                    likes = it.likes
                )
            )
        }
        return arrayList
    }
}
package ua.czrblz.data.mappers

import ua.czrblz.data.models.VideoDBModel
import ua.czrblz.domain.model.VideoModel

class DatabaseMappers {

    fun toVideoModel(list: List<VideoDBModel>): List<VideoModel> {
        val arrayList: ArrayList<VideoModel> = ArrayList()
        list.forEach {
            arrayList.add(
                VideoModel(
                    id = it.id,
                    title = it.title,
                    duration = it.duration,
                    videoUrl = it.videoUrl,
                    videoThumbnail = it.videoThumbnail,
                    likes = it.likes
                )
            )
        }
        return arrayList
    }

    fun toVideoDBModel(list: List<VideoModel>): List<VideoDBModel> {
        val arrayList: ArrayList<VideoDBModel> = ArrayList()
        list.forEach {
            arrayList.add(
                VideoDBModel(
                    id = it.id,
                    title = it.title,
                    duration = it.duration,
                    videoUrl = it.videoUrl,
                    videoThumbnail = it.videoThumbnail,
                    likes = it.likes
                )
            )
        }
        return arrayList
    }
}

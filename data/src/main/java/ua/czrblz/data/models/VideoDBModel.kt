package ua.czrblz.data.models

import androidx.room.Entity

@Entity(primaryKeys = ["id"])
data class VideoDBModel(
    val id: Int,
    val title: String,
    val duration: Int,
    val videoUrl: String,
    val videoThumbnail: String,
    val likes: Int
)
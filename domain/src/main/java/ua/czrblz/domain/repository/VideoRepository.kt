package ua.czrblz.domain.repository

import ua.czrblz.domain.model.VideoModel

interface VideoRepository {
    suspend fun getVideo(): Result<List<VideoModel>>
}
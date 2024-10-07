package ua.czrblz.domain.repository

import kotlinx.coroutines.flow.Flow
import ua.czrblz.domain.model.VideoModel

interface DatabaseRepository {

    suspend fun saveVideosInfoInDB(videoList: List<VideoModel>)
    fun getVideosUrl(videoList: List<VideoModel>): List<String>
    fun getVideosFromDBFlow(): Flow<List<VideoModel>>
}
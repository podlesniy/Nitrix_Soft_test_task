package ua.czrblz.data.repository

import kotlinx.coroutines.flow.Flow
import ua.czrblz.data.db.VideosDao
import ua.czrblz.domain.model.VideoModel
import ua.czrblz.domain.repository.DatabaseRepository

class DatabaseRepositoryImpl(
    private val videosDao: VideosDao
): DatabaseRepository {

    override suspend fun saveVideosInfoInDB(videoList: List<VideoModel>) {
        TODO("Not yet implemented")
    }

    override fun getVideosFromDBFlow(): Flow<List<VideoModel>> {
        TODO("Not yet implemented")
    }


}
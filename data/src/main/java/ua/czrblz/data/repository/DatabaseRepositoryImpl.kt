package ua.czrblz.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import ua.czrblz.data.db.VideosDao
import ua.czrblz.data.mappers.DatabaseMappers
import ua.czrblz.domain.model.VideoModel
import ua.czrblz.domain.repository.DatabaseRepository

class DatabaseRepositoryImpl(
    private val videosDao: VideosDao,
    private val databaseMappers: DatabaseMappers
): DatabaseRepository {

    override suspend fun saveVideosInfoInDB(videoList: List<VideoModel>) {
        videosDao.insertAll(databaseMappers.toVideoDBModel(videoList))
    }

    override fun getVideosFromDBFlow(): Flow<List<VideoModel>> =
        videosDao.getAllVideo().map {
            databaseMappers.toVideoModel(it)
        }
}
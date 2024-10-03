package ua.czrblz.data.repository

import ua.czrblz.data.api.ApiService
import ua.czrblz.domain.model.VideoModel
import ua.czrblz.domain.repository.VideoRepository

class VideoRepositoryImpl(
    private val apiService: ApiService
): VideoRepository {

    override suspend fun getVideo(page: Int): Result<List<VideoModel>> {
        TODO("Not yet implemented")
    }

}

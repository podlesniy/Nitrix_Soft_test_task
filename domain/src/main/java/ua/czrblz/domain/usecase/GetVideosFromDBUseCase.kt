package ua.czrblz.domain.usecase

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import ua.czrblz.domain.model.VideoModel
import ua.czrblz.domain.repository.DatabaseRepository

class GetVideosFromDBUseCase(
    private val databaseRepository: DatabaseRepository
) {

    suspend operator fun invoke(): Flow<List<VideoModel>> = withContext(Dispatchers.IO) {
        databaseRepository.getVideosFromDBFlow()
    }
}
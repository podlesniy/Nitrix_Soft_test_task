package ua.czrblz.domain.usecase

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import ua.czrblz.domain.repository.VideoRepository

class GetVideosFromServerUseCase(
    private val videoRepository: VideoRepository
) {
    suspend operator fun invoke() = withContext(Dispatchers.IO) {
        videoRepository.getVideo()
    }
}
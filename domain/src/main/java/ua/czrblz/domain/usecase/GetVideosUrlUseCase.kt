package ua.czrblz.domain.usecase

import ua.czrblz.domain.model.VideoModel
import ua.czrblz.domain.repository.DatabaseRepository

class GetVideosUrlUseCase(
    private val databaseRepository: DatabaseRepository
) {

    operator fun invoke(videoList: List<VideoModel>): List<String> =
        databaseRepository.getVideosUrl(videoList)
}
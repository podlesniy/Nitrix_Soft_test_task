package ua.czrblz.domain.usecase

import ua.czrblz.domain.model.VideoModel
import ua.czrblz.domain.repository.DatabaseRepository

class SaveVideosInfoToDBUseCase(
    private val databaseRepository: DatabaseRepository
) {

    suspend operator fun invoke(videoList: List<VideoModel>) {
        databaseRepository.saveVideosInfoInDB(videoList)
    }
}
package ua.czrblz.domain.usecase

import ua.czrblz.domain.repository.VideoRepository

class GetVideosFromServerUseCase(
    private val videoRepository: VideoRepository
) {

}
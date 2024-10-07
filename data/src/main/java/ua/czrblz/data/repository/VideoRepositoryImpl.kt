package ua.czrblz.data.repository

import retrofit2.Response
import ua.czrblz.data.api.ApiService
import ua.czrblz.data.mappers.VideoMappers
import ua.czrblz.domain.model.VideoModel
import ua.czrblz.domain.repository.VideoRepository
import java.net.HttpURLConnection.HTTP_OK

class VideoRepositoryImpl(
    private val apiService: ApiService,
    private val videoMappers: VideoMappers
): VideoRepository {

    override suspend fun getVideo(page: Int): Result<List<VideoModel>> = Result.fromAsyncResponse {
        apiService.getVideos(page = page)
    }.map { response ->
        videoMappers.toVideoModel(response.hits)
    }

    private suspend fun <T> Result.Companion.fromAsyncResponse(action: suspend () -> Response<T>): Result<T> {
        return try {
            action().checkResponseCode()
        } catch (e: Exception) {
            failure(e)
        }
    }

    private fun <T> Response<T>.checkResponseCode(): Result<T> =
        when (code()) {
            HTTP_OK -> success()
            else -> generalError()
        }


    private fun <T> Response<T>.success(): Result<T> =
        try {
            body()?.let { body ->
                Result.success(body)
            } ?: Result.failure(Throwable("Invalid response data"))
        } catch (cause: Exception) {
            Result.failure(cause)
        }

    private fun <T> Response<T>.generalError(): Result<T> =
        try {
            Result.failure(Throwable(message()))
        } catch (cause: Exception) {
            Result.failure(cause)
        }
}

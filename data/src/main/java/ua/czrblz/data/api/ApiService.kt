package ua.czrblz.data.api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import ua.czrblz.data.models.VideosResponseModel

const val API_KEY = "46313356-f9e1aa5f03874f33e58e28732"
interface ApiService {

    @GET("videos/")
    suspend fun getVideos(
        @Query("key") apiKey: String = API_KEY,
        @Query("page") page: Int,
        @Query("per_page") perPage: Int = 10,
    ): Response<VideosResponseModel>
}
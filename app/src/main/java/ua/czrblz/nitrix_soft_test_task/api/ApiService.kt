package ua.czrblz.nitrix_soft_test_task.api

import retrofit2.http.GET
import retrofit2.http.Query
import ua.czrblz.nitrix_soft_test_task.api.models.MoviesModel

const val API_KEY = "46313356-f9e1aa5f03874f33e58e28732"
interface ApiService {

    @GET("videos/")
    fun getNowPlayingMovies(
        @Query("key") apiKey: String = API_KEY,
        @Query("page") page: Int,
        @Query("per_page") perPage: Int,
    ): Result<MoviesModel>
}
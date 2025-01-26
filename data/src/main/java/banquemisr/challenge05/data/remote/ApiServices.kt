package banquemisr.challenge05.data.remote

import banquemisr.challenge05.domain.entity.MoviesResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiServices {

    @GET("now_playing?language=en-US")
    suspend fun getNowPlayingMovies(@Query("page") page: Int): MoviesResponse

    @GET("popular?language=en-US")
    suspend fun getPopularMovies(@Query("page") page: Int): MoviesResponse

    @GET("upcoming?language=en-US")
    suspend fun getUpcomingMovies(@Query("page") page: Int): MoviesResponse

}
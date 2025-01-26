package banquemisr.challenge05.data.repository

import banquemisr.challenge05.data.remote.ApiServices
import banquemisr.challenge05.domain.entity.MoviesResponse
import banquemisr.challenge05.domain.repo.MoviesRepo

class MoviesRepoImpl(private val apiServices: ApiServices) : MoviesRepo{
    override suspend fun getNowPlaying(page: Int): MoviesResponse = apiServices.getNowPlayingMovies(page)

    override suspend fun getPopular(page: Int): MoviesResponse = apiServices.getPopularMovies(page)

    override suspend fun getUpcoming(page: Int): MoviesResponse = apiServices.getUpcomingMovies(page)
}
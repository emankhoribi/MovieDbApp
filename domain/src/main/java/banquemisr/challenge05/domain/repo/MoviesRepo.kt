package banquemisr.challenge05.domain.repo

import banquemisr.challenge05.domain.entity.MoviesResponse

interface MoviesRepo {

    suspend fun getNowPlaying(page: Int): MoviesResponse
    suspend fun getPopular(page: Int): MoviesResponse
    suspend fun getUpcoming(page: Int): MoviesResponse
}
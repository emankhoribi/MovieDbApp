package banquemisr.challenge05.domain.repo

import banquemisr.challenge05.domain.entity.details.MovieDetailsResponse

interface MovieDetailsRepo {

    suspend fun getMovieDetails(id: Int): MovieDetailsResponse
}
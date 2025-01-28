package banquemisr.challenge05.data.repository

import banquemisr.challenge05.data.remote.ApiServices
import banquemisr.challenge05.domain.entity.details.MovieDetailsResponse
import banquemisr.challenge05.domain.repo.MovieDetailsRepo

class MovieDetailsRepoImpl(private val apiServices: ApiServices) : MovieDetailsRepo {
    override suspend fun getMovieDetails(id: Int): MovieDetailsResponse =
        apiServices.getMovieDetails(id)
}
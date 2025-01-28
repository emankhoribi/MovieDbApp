package banquemisr.challenge05.domain.usecase

import banquemisr.challenge05.domain.entity.details.MovieDetailsResponse
import banquemisr.challenge05.domain.repo.MovieDetailsRepo

class MovieDetailsUseCase(private val movieDetailsRepo: MovieDetailsRepo) {

    suspend operator fun invoke(id: Int): MovieDetailsResponse =
        movieDetailsRepo.getMovieDetails(id)
}
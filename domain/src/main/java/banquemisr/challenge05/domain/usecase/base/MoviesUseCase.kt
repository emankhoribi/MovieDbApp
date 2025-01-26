package banquemisr.challenge05.domain.usecase.base

import banquemisr.challenge05.domain.entity.MoviesResponse

interface MoviesUseCase {
    suspend operator fun invoke(page: Int): MoviesResponse
}
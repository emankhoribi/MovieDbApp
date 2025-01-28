package banquemisr.challenge05.domain.usecase

import banquemisr.challenge05.domain.repo.MoviesRepo
import banquemisr.challenge05.domain.usecase.base.MoviesUseCase

class PopularUseCase(private val moviesRepo: MoviesRepo): MoviesUseCase {
    override suspend operator fun invoke(page: Int) = moviesRepo.getPopular(page)
}
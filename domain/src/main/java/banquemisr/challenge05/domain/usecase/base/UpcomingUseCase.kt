package banquemisr.challenge05.domain.usecase.base

import banquemisr.challenge05.domain.repo.MoviesRepo

class UpcomingUseCase(private val moviesRepo: MoviesRepo): MoviesUseCase {
    override suspend operator fun invoke(page: Int) = moviesRepo.getUpcoming(page)
}
package banquemisr.challenge05.moviedbapp.di.module

import banquemisr.challenge05.domain.repo.MoviesRepo
import banquemisr.challenge05.domain.usecase.base.MoviesUseCase
import banquemisr.challenge05.domain.usecase.base.NowPlayingUseCase
import banquemisr.challenge05.domain.usecase.base.PopularUseCase
import banquemisr.challenge05.domain.usecase.base.UpcomingUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    fun provideNowPlayingUseCase(moviesRepo: MoviesRepo): MoviesUseCase =
        NowPlayingUseCase(moviesRepo)

    @Provides
    fun providePopularUseCase(moviesRepo: MoviesRepo): MoviesUseCase =
        PopularUseCase(moviesRepo)

    @Provides
    fun provideUpcomingUseCase(moviesRepo: MoviesRepo): MoviesUseCase =
        UpcomingUseCase(moviesRepo)
}
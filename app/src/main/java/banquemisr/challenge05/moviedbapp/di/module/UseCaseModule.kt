package banquemisr.challenge05.moviedbapp.di.module

import banquemisr.challenge05.domain.repo.MovieDetailsRepo
import banquemisr.challenge05.domain.repo.MoviesRepo
import banquemisr.challenge05.domain.usecase.MovieDetailsUseCase
import banquemisr.challenge05.domain.usecase.NowPlayingUseCase
import banquemisr.challenge05.domain.usecase.PopularUseCase
import banquemisr.challenge05.domain.usecase.UpcomingUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    fun provideNowPlayingUseCase(moviesRepo: MoviesRepo): NowPlayingUseCase =
        NowPlayingUseCase(moviesRepo)

    @Provides
    fun providePopularUseCase(moviesRepo: MoviesRepo): PopularUseCase =
        PopularUseCase(moviesRepo)

    @Provides
    fun provideUpcomingUseCase(moviesRepo: MoviesRepo): UpcomingUseCase =
        UpcomingUseCase(moviesRepo)

    @Provides
    fun provideMovieDetailsUseCase(movieDetailsRepo: MovieDetailsRepo): MovieDetailsUseCase =
        MovieDetailsUseCase(movieDetailsRepo)
}
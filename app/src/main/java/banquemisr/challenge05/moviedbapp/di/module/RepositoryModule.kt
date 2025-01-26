package banquemisr.challenge05.moviedbapp.di.module

import banquemisr.challenge05.data.remote.ApiServices
import banquemisr.challenge05.data.repository.MoviesRepoImpl
import banquemisr.challenge05.domain.repo.MoviesRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun provideMovieRepository(apiServices: ApiServices): MoviesRepo = MoviesRepoImpl(apiServices)
}
package banquemisr.challenge05.moviedbapp.screen.movielist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import banquemisr.challenge05.domain.entity.MoviesResult
import banquemisr.challenge05.domain.usecase.NowPlayingUseCase
import banquemisr.challenge05.domain.usecase.PopularUseCase
import banquemisr.challenge05.domain.usecase.UpcomingUseCase
import banquemisr.challenge05.moviedbapp.utils.MoviesPaging
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class MovieListViewModel @Inject constructor(
    private val nowPlayingUseCase: NowPlayingUseCase,
    private val popularUseCase: PopularUseCase,
    private val upcomingUseCase: UpcomingUseCase
) : ViewModel() {

    fun getNowPlayingMovieList(): Flow<PagingData<MoviesResult>> {
        return Pager(config = PagingConfig(pageSize = 20),
            pagingSourceFactory = { MoviesPaging(nowPlayingUseCase) }).flow.cachedIn(viewModelScope)
    }

    fun getPopularMovieList(): Flow<PagingData<MoviesResult>> {
        return Pager(config = PagingConfig(pageSize = 20),
            pagingSourceFactory = { MoviesPaging(popularUseCase) }).flow.cachedIn(viewModelScope)
    }

    fun getUpcomingMovieList(): Flow<PagingData<MoviesResult>> {
        return Pager(config = PagingConfig(pageSize = 20),
            pagingSourceFactory = { MoviesPaging(upcomingUseCase) }).flow.cachedIn(viewModelScope)
    }

}
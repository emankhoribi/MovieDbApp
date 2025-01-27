package banquemisr.challenge05.moviedbapp.utils

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import banquemisr.challenge05.domain.entity.MoviesResult
import banquemisr.challenge05.domain.usecase.base.MoviesUseCase

class MoviesPaging(private val moviesUseCase: MoviesUseCase) :
    PagingSource<Int, MoviesResult>() {
    override fun getRefreshKey(state: PagingState<Int, MoviesResult>): Int? {
        return state.anchorPosition?.let {
            val anchorPage = state.closestPageToPosition(it)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, MoviesResult> {
        val page = params.key ?: 1

        return try {
            val data = moviesUseCase(page)

            Log.d("TAG", "load: ${data.results}")
            LoadResult.Page(
                data = data.results,
                prevKey = if (page == 1) null else page - 1,
                nextKey = if (data.results.isEmpty()) null else page + 1
            )
        } catch (e: Exception) {
            Log.d("TAG", "load: ${e.message}")
            LoadResult.Error(e)

        }
    }


}
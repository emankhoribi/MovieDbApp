package banquemisr.challenge05.moviedbapp.screen.movielist

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import banquemisr.challenge05.domain.entity.MoviesResult
import kotlinx.coroutines.launch

@Composable
fun MovieListScreen(
    navController: NavController,
    movieListViewModel: MovieListViewModel = hiltViewModel()
) {
    val pagerState = rememberPagerState(pageCount = { TabPage.entries.size })
    val scope = rememberCoroutineScope()

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Scaffold(topBar = {
            TabMovies(
                selectedIndex = pagerState.currentPage,
                onSelectedTab = {
                    scope.launch {
                        pagerState.animateScrollToPage(it.ordinal)
                    }
                }
            )
        }) {
            HorizontalPager(
                state = pagerState,
                modifier = Modifier.padding(it)
            ) { index ->
                Column(Modifier.fillMaxSize()) {
                    when (index) {
                        0 -> {
                            val nowPLayingResult = movieListViewModel.getNowPlayingMovieList()
                                .collectAsLazyPagingItems()
                            Movies(navController, movieResult = nowPLayingResult)
                        }

                        1 -> {
                            val popularResult =
                                movieListViewModel.getPopularMovieList().collectAsLazyPagingItems()
                            Movies(navController, movieResult = popularResult)
                        }

                        else -> {
                            val upcomingResult =
                                movieListViewModel.getUpcomingMovieList().collectAsLazyPagingItems()

                            Movies(navController, movieResult = upcomingResult)
                        }
                    }
                }
            }

        }
    }
}


@Composable
fun Movies(
    navController: NavController,
    modifier: Modifier = Modifier,
    movieResult: LazyPagingItems<MoviesResult>
) {


    when (movieResult.loadState.refresh) {
        LoadState.Loading -> {

        }

        is LoadState.Error -> {

        }

        else -> {
            LazyRow(modifier,
                verticalAlignment = Alignment.CenterVertically) {
                items(movieResult.itemCount) { index ->
                    movieResult[index]?.let { item ->
                        MovieItem(
                            movieResult = item,
                            modifier = Modifier
                                .fillMaxHeight(0.5f)
                                .fillMaxWidth(0.5f)

                                .padding(horizontal = 15.dp)
                        )
                    }

                }
            }
        }

    }
}




package banquemisr.challenge05.moviedbapp.screen.moviedetails

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.produceState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import banquemisr.challenge05.domain.entity.details.MovieDetailsResponse
import banquemisr.challenge05.moviedbapp.ui.theme.Typography
import banquemisr.challenge05.moviedbapp.utils.Constants
import banquemisr.challenge05.moviedbapp.utils.Resource
import coil.compose.AsyncImage

@Composable
fun MovieDetailsScreen(
    navController: NavController,
    viewModel: MovieDetailsViewModel = hiltViewModel(),
    modifier: Modifier = Modifier,
    id: Int
) {

    val movieDetails =
        produceState<Resource<MovieDetailsResponse>>(initialValue = Resource.Loading()) {
            value = viewModel.getMovieDetails(id)
        }.value

    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Box(
            contentAlignment = Alignment.TopStart,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.1f)
                .align(Alignment.Start)
                .background(
                    Brush.verticalGradient(
                        listOf(
                            Color.Black,
                            Color.Transparent
                        )
                    )
                )


        ) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier
                    .size(36.dp)
                    .offset(16.dp, 16.dp)
                    .clickable {
                        navController.popBackStack()
                    }
            )
        }

        MovieDetailStateWrapper(
            movieDetails = movieDetails,

            loadingModifier = Modifier
                .size(100.dp)
                .align(Alignment.CenterHorizontally)
                .padding(
                    top = 16.dp,
                    start = 16.dp,
                    end = 16.dp,
                    bottom = 16.dp
                )
        )
        Spacer(modifier = Modifier.width(15.dp))
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .weight(1f, false)
        ) {
            Column(
                Modifier
                    .fillMaxWidth()
                    .height(300.dp),

                horizontalAlignment = Alignment.CenterHorizontally,

                ) {
                if (movieDetails is Resource.Success) {
                    AsyncImage(
                        model = Constants.IMAGE_BASE_ORIGINAL.plus(movieDetails.data?.poster_path),
                        contentDescription = movieDetails.data?.title,
                        modifier = Modifier,
                        contentScale = ContentScale.FillBounds
                    )
                }
            }

            Column(
                Modifier
                    .padding(15.dp),

            ) {
                if (movieDetails is Resource.Success) {
                    Text(
                        text = movieDetails.data?.title!!,
                        fontSize = 16.sp
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Description",
                        fontSize = 14.sp,
                        color = Color.Red
                    )
                    Text(
                        text = movieDetails.data.overview.plus("kjfhsjkfhksfjkshfuhfsfhsufhsufhsfhsjfhsjfh sjfhskfhskfhskjfhsjfhs ksjfhksjfhskjfhsjkfhskfhskfhsjdkdakhfkajkdhakhakdh"),
                        fontSize = 18.sp
                    )

                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Genre",
                        fontSize = 14.sp,
                        color = Color.Red
                    )

                    var genreText: String = ""
                    for (genre in movieDetails.data.genres) {
                        if (genreText.isNotEmpty()) {
                            genreText = genreText.plus(",")
                        }
                        genreText = genreText.plus(genre.name)
                    }
                    Text(
                        text = genreText,
                        fontSize = 14.sp
                    )

                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Runtime",
                        fontSize = 14.sp,
                        color = Color.Red
                    )
                    val runtime = " ${movieDetails.data.runtime} minutes"
                    Text(
                        text = runtime,
                        fontSize = 14.sp
                    )
                    Spacer(modifier = Modifier.height(40.dp))

                }


            }
        }

    }
}


@Composable
fun MovieDetailStateWrapper(
    movieDetails: Resource<MovieDetailsResponse>,
    loadingModifier: Modifier
) {
    when(movieDetails){
        is Resource.Loading -> {
            CircularProgressIndicator(
                color = MaterialTheme.colorScheme.primary,
                modifier = loadingModifier
            )
        }

        is Resource.Error -> {
            Toast.makeText(LocalContext.current, movieDetails.message, Toast.LENGTH_SHORT).show()
        }
        is Resource.Success -> {}
    }
}

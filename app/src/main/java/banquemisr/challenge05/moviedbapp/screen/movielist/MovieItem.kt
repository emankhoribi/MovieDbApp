package banquemisr.challenge05.moviedbapp.screen.movielist

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Text
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import banquemisr.challenge05.domain.entity.MoviesResult
import banquemisr.challenge05.moviedbapp.ui.theme.Typography
import banquemisr.challenge05.moviedbapp.utils.Constants
import coil.compose.AsyncImage


@Composable
fun MovieItem(
   movieResult: MoviesResult,
   modifier:Modifier = Modifier,
   navController: NavController
){
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .clickable {
                navController.navigate(
                    "movie_details_screen/${movieResult.id}"
                )
            },

        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp
        )
    ) {
        Column(
            modifier = modifier,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.width(15.dp))
            Column(
                Modifier.fillMaxSize().weight(0.7f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.padding(top = 30.dp))
                AsyncImage(
                    model = Constants.IMAGE_BASE.plus(movieResult.poster_path),
                    contentDescription = movieResult.title,
                    modifier = Modifier
                )
            }

            Column(
                Modifier.fillMaxHeight().weight(0.8f)
                    .padding(30.dp)
            ) {
                Text(
                    text = movieResult.title,
                    style = Typography.headlineSmall
                )


            }

        }
    }
}
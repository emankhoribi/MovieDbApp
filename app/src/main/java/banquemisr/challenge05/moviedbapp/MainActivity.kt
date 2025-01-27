package banquemisr.challenge05.moviedbapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import banquemisr.challenge05.moviedbapp.screen.movielist.MovieListScreen
import banquemisr.challenge05.moviedbapp.ui.theme.MovieDbAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MovieDbAppTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = "movie_list_screen"
                ) {

                    composable("movie_list_screen"){
                        MovieListScreen(navController = navController)
                    }
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MovieDbAppTheme {
        val navController = rememberNavController()
        NavHost(
            navController = navController,
            startDestination = "movie_list_screen"
        ) {
            composable("movie_list_screen"){
                MovieListScreen(navController = navController)
            }
        }
    }
}
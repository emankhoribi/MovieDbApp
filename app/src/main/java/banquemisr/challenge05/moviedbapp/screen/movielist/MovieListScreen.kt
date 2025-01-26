package banquemisr.challenge05.moviedbapp.screen.movielist

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun MovieListScreen(
    navController: NavController
) {
    var tabPage by remember { mutableStateOf(TabPage.NowPLaying) }
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Scaffold(topBar = {
            TabMovies(
                selectedIndex = tabPage.ordinal,
                onSelectedTab = {tabPage = it}
            )
        }) {
            Column (modifier = Modifier.padding(it)){
                Text(text = "HELLO")
            }

        }
    }
}
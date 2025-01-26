package banquemisr.challenge05.moviedbapp.screen.movielist

import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier


enum class TabPage() {
    NowPLaying,
    Popular,
    Upcoming
}

@Composable
fun TabMovies(selectedIndex: Int, onSelectedTab: (TabPage) -> Unit) {
    TabRow(selectedTabIndex = selectedIndex) {
        TabPage.entries.forEachIndexed { index, tabPage ->
            Tab(
                selected = index == selectedIndex,
                onClick = { onSelectedTab(tabPage) }) {
                Text(text = tabPage.name)
            }
        }
    }
}

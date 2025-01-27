package banquemisr.challenge05.moviedbapp.screen.movielist

import android.R
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


enum class TabPage() {
    NowPLaying,
    Popular,
    Upcoming
}

@Composable
fun TabMovies(selectedIndex: Int, onSelectedTab: (TabPage) -> Unit) {
    TabRow(
        selectedTabIndex = selectedIndex,
        divider = {
            Spacer(
                modifier = Modifier.height(5.dp)
            )
        },
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.1f)
    ) {
        TabPage.entries.forEachIndexed { index, tabPage ->
            Tab(
                selected = index == selectedIndex,
                modifier = Modifier.padding(4.dp),
                selectedContentColor = Color.Magenta,
                unselectedContentColor = Color.Black,
                onClick = { onSelectedTab(tabPage) }) {
                Text(text = tabPage.name)
            }


        }
    }
}

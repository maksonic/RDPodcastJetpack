package ru.maksonic.rdpodcast.screen.collection

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import ru.maksonic.rdpodcast.shared.ui.theme.RDTheme

/**
 * @Author: maksonic on 04.03.2022
 */
@Composable
fun CollectionScreen() {
    CollectionUiScreen()
}

@Composable
fun CollectionUiScreen(modifier: Modifier = Modifier) {
    Scaffold(
        backgroundColor = RDTheme.color.background
    ) {
        LazyColumn(
            modifier.padding(start = RDTheme.padding.dp16, end = RDTheme.padding.dp16)) {
            item { Text("Коллекция", style = RDTheme.typography.display) }
        }
    }
}
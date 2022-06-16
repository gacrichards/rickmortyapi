package com.switchboard.rickandmortyapi

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.AsyncImage
import com.switchboard.rickandmortyapi.model.Cartoon

@OptIn(ExperimentalCoilApi::class)
@Composable
fun CartoonItemView(cartoon: Cartoon) {
    Row(
        modifier = Modifier.padding(12.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        AsyncImage(
            model = cartoon.image,
            contentDescription = "Cartoon image view",
            modifier = Modifier.size(64.dp).clip(CircleShape)
        )
        Text(
            text = cartoon.name
        )
    }
}

@Preview
@Composable
fun ComposablePreview() {
    CartoonItemView(
        Cartoon(
            "Cole",
            "https://live.staticflickr.com/5094/5509931023_10821f02fd_k.jpg"
        )
    )
}
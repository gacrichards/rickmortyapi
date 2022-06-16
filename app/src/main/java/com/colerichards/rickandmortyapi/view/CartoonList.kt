package com.switchboard.rickandmortyapi.view

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.LiveData
import com.switchboard.rickandmortyapi.CartoonItemView
import com.switchboard.rickandmortyapi.model.Cartoon

interface ListDataSource {
    fun loadMoreData()
}

@Composable
fun CartoonList(liveCartoons: LiveData<List<Cartoon>>, source: ListDataSource) {
    val items by liveCartoons.observeAsState(initial = emptyList())

    LazyColumn {
        itemsIndexed(items = items) { index, cartoon ->
            if (index == items.lastIndex) {
                source.loadMoreData()
            }
            CartoonItemView(cartoon = cartoon)
        }
    }
}
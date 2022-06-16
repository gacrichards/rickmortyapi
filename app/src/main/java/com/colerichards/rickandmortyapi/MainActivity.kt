package com.switchboard.rickandmortyapi

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.Scaffold
import com.switchboard.rickandmortyapi.view.CartoonList
import com.switchboard.rickandmortyapi.view.ListDataSource
import com.switchboard.rickandmortyapi.viewmodel.RickMortyViewModel


class MainActivity : AppCompatActivity() {

    val viewModel: RickMortyViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.fetchCartoons()

        setContent {
            Scaffold {
                CartoonList(
                    liveCartoons = viewModel.cartoons,
                    object : ListDataSource {
                        override fun loadMoreData() {
                            viewModel.fetchCartoons()
                        }
                    }
                )
            }
        }
    }


}
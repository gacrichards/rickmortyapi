package com.switchboard.rickandmortyapi.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.switchboard.rickandmortyapi.data.RetrofitWrapper
import com.switchboard.rickandmortyapi.model.Cartoon
import kotlinx.coroutines.launch

class RickMortyViewModel: ViewModel() {

    private val _cartoons: MutableLiveData<List<Cartoon>> = MutableLiveData(emptyList())
    val cartoons: LiveData<List<Cartoon>> = _cartoons

    private val retrofitWrapper = RetrofitWrapper()
    private var nextPage: Int = 0
    private var maxPage: Int = Int.MAX_VALUE

    fun fetchCartoons(){
        viewModelScope.launch {
            if (nextPage < maxPage){
                nextPage ++

                retrofitWrapper.fetchCharacters(nextPage)?.let{ response ->
                    var temp = mutableListOf<Cartoon>()
                    temp.addAll(_cartoons.value ?: emptyList())
                    temp.addAll(response.results)
                    _cartoons.value = temp
                    maxPage = response.info.pages
                }
            }

        }
    }
}
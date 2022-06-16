package com.switchboard.rickandmortyapi.data

import com.switchboard.rickandmortyapi.model.ApiResult
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface RickMortyApi {
    @GET("character")
    suspend fun getAllCharacter(@Query("page") page: Int = 1): Response<ApiResult>
}
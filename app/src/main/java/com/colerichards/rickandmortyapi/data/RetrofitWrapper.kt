package com.switchboard.rickandmortyapi.data

import android.util.Log
import com.switchboard.rickandmortyapi.model.ApiResult
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitWrapper {

    companion object {
        private const val TAG = "RETROFIT"
        private const val BASE_URL = "https://rickandmortyapi.com/api/"
    }

    private val rickMortyApi: RickMortyApi? by lazy {
        retrofit?.create(RickMortyApi::class.java)
    }

    private val retrofit by lazy {
        val client = OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
            .build()

        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }

    suspend fun fetchCharacters(page: Int = 1): ApiResult? {
        return rickMortyApi?.getAllCharacter(page)?.let { response ->
            (if (response.isSuccessful) {
                response.body()
            } else {
                Log.e(TAG, "Oh no! api was unsuccessfull")
                return null
            }) as ApiResult
        }
    }
}
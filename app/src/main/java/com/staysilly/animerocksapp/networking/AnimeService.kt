package com.staysilly.animerocksapp.networking

import com.staysilly.animerocksapp.models.AnimeCharactersResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface AnimeService {

    @GET("search/anime")
    suspend fun getAllAnime(@Query("q") query: String): AnimeCharactersResponse

}
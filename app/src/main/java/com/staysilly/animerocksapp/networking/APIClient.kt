package com.staysilly.animerocksapp.networking

import com.staysilly.animerocksapp.models.AnimeCharactersResponse
import com.staysilly.animerocksapp.utils.Globals
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class APIClient {

    var service: AnimeService

    init {
        val retrofit = Retrofit.Builder().baseUrl(Globals.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()
        service = retrofit.create(AnimeService::class.java)
    }

    //get the list of now playing movies
    suspend fun getAnimeCharcterDetails(charcterName: String): AnimeCharactersResponse{
        return service.getAllAnime(charcterName)
    }

}
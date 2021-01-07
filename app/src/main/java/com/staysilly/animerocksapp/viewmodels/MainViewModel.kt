package com.staysilly.animerocksapp.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.staysilly.animerocksapp.models.AnimeCharactersResponse
import com.staysilly.animerocksapp.repositories.MainRepository

class MainViewModel: ViewModel() {

    fun getAnimeCharcterDetails(charcterName: String): LiveData<AnimeCharactersResponse>{
        val repo = MainRepository()
        return repo.getAnimeCharcterDetails(charcterName)
    }
}
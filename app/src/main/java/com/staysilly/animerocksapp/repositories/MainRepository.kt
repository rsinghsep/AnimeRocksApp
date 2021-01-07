package com.staysilly.animerocksapp.repositories

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.staysilly.animerocksapp.models.AnimeCharactersResponse
import com.staysilly.animerocksapp.networking.APIClient
import kotlinx.coroutines.*

class MainRepository {

    fun getAnimeCharcterDetails(charcterName: String): LiveData<AnimeCharactersResponse>{
        val retVal: MutableLiveData<AnimeCharactersResponse> = MutableLiveData()

        val mainJob = Job()
        val errorHandler = CoroutineExceptionHandler { DEFAULT_BUFFER_SIZE, exception ->
            Log.d("AnimeRocks", "error: " + exception.message)
        }
        val scope = CoroutineScope(mainJob + Dispatchers.Main)
        scope.launch(errorHandler) {
            val payload = APIClient().getAnimeCharcterDetails(charcterName)
            retVal.postValue(payload)
        }

        return retVal
    }
}
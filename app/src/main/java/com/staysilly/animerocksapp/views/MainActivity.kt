package com.staysilly.animerocksapp.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.staysilly.animerocksapp.R
import com.staysilly.animerocksapp.databinding.ActivityMainBinding
import com.staysilly.animerocksapp.viewmodels.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var dataBinding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    private fun initDataBinding(){
        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = MainViewModel()
        dataBinding.lifecycleOwner = this
    }
    private fun loadAnimeCharcterByName(){
        val name = "naruto"
        viewModel.getAnimeCharcterDetails(name).observe(this, Observer {
            Log.d("AnimeRocks", "anime api response received" + it.results)
        })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initDataBinding()
        loadAnimeCharcterByName()
    }

}
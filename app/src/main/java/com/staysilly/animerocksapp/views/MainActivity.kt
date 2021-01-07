package com.staysilly.animerocksapp.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.staysilly.animerocksapp.R
import com.staysilly.animerocksapp.databinding.ActivityMainBinding
import com.staysilly.animerocksapp.viewmodels.MainViewModel
import com.staysilly.animerocksapp.views.adapters.AnimeAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var dataBinding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    private lateinit var adapter: AnimeAdapter

    private fun initDataBinding(){
        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = MainViewModel()
        dataBinding.lifecycleOwner = this
    }
    private fun loadAnimeCharcterByName(){
        val name = "naruto"
        viewModel.getAnimeCharcterDetails(name).observe(this, Observer {
            Log.d("AnimeRocks", "anime api response received" + it.results)
            adapter.data = it.results
            adapter.notifyDataSetChanged()
        })
    }
    private fun setUpRecyclerView(){
        val recyclerView = dataBinding.lstAnimeCharcter
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        adapter = AnimeAdapter()
        recyclerView.adapter = adapter
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initDataBinding()
        setUpRecyclerView()
        loadAnimeCharcterByName()
    }

}
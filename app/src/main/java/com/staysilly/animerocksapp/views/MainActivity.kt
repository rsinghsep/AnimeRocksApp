package com.staysilly.animerocksapp.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.LinearLayout
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.floatingactionbutton.FloatingActionButton
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
    private fun loadAnimeCharcterByName(name: String){
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
    private fun setUpSearch(){
        var search: FloatingActionButton = dataBinding.fabSearch
        search.setOnClickListener(View.OnClickListener {
            Log.d("hello", "search is clicked")
            showSearchDialog()
        })
    }
    private fun showSearchDialog(){
        val alertDialog: AlertDialog.Builder = AlertDialog.Builder(this)
        val searchText = EditText(this)
        alertDialog.setTitle("Search Anime Characters")
        val layout= LinearLayout(this)
        layout.orientation = LinearLayout.VERTICAL
        layout.addView(searchText)
        alertDialog.setView(layout)
        alertDialog.setPositiveButton("search"){
            dialogInterface, i ->
            val charcterName = searchText.text.toString()
            loadAnimeCharcterByName(charcterName)
        }
        alertDialog.show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initDataBinding()
        setUpRecyclerView()
        loadAnimeCharcterByName("naruto")
        setUpSearch()
    }


}
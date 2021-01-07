package com.staysilly.animerocksapp.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initDataBinding()
    }

}
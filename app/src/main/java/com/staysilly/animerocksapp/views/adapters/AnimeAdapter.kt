package com.staysilly.animerocksapp.views.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.staysilly.animerocksapp.R
import com.staysilly.animerocksapp.databinding.RowAnimeDetailBinding
import com.staysilly.animerocksapp.models.AnimeCharacter

class AnimeAdapter : RecyclerView.Adapter<AnimeAdapter.AnimeViewHolder>() {

    var data: List<AnimeCharacter> = ArrayList()
    lateinit var dataBinding: RowAnimeDetailBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimeViewHolder {
        dataBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.row_anime_detail, parent, false)
        return AnimeViewHolder(dataBinding)
    }
    override fun getItemCount(): Int {
        return data.size
    }
    override fun onBindViewHolder(holder: AnimeViewHolder, position: Int) {
        holder.bindData(data[position])
    }



    class AnimeViewHolder(dataBinding: RowAnimeDetailBinding) : RecyclerView.ViewHolder(dataBinding.root){

        val  binding : RowAnimeDetailBinding = dataBinding

        fun bindData(animeCharcter: AnimeCharacter){
            binding.animeCharcter = animeCharcter
        }
    }

}
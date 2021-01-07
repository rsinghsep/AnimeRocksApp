package com.staysilly.animerocksapp.views.adapters;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.squareup.picasso.Picasso;

public class BindingAdapterNew {

    @BindingAdapter("thumbnailUrl")
    public static void setImage(ImageView imageView, String url){
        Picasso.with(imageView.getContext()).load(url).into(imageView);
    }
}

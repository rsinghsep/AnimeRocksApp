package com.staysilly.animerocksapp.views.adapters;

import androidx.databinding.BindingConversion;

public class Converters {

    @BindingConversion
    public static String convertIntToString(int count){
        return String.valueOf(count);
    }

}

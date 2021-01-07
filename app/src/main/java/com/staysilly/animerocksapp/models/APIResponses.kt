package com.staysilly.animerocksapp.models

data class AnimeCharactersResponse(
    var results: List<AnimeCharacter>
)

data class AnimeCharacter(
    var mal_id: Int,
    var url: String,
    var image_url: String,
    var title: String,
    var airing: Boolean,
    var synopsis: String,
    var type: String,
    var episodes: Int,
    var score: Double,
    var start_date: String,
    var end_date: String,
    var members: Int,
    var rated: String
)
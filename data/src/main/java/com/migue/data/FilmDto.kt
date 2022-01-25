package com.migue.data

import android.icu.text.CaseMap
import com.google.gson.annotations.SerializedName

data class FilmDto(

    @SerializedName("id") val id : Int,
    @SerializedName ("title")val title: String,
    @SerializedName("name")val name: String,
    @SerializedName("overview")val description: String,
    @SerializedName("vote_average")val rating: Double,
    @SerializedName("poster_path")val imageUrl: String
)

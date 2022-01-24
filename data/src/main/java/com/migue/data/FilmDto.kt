package com.migue.data

import android.icu.text.CaseMap
import com.google.gson.annotations.SerializedName

data class FilmDto(

    @SerializedName("id") val id : Int,
    @SerializedName ("title")val title: String,
    @SerializedName("description")val description: String,
    @SerializedName("rating")val rating: String,
    @SerializedName("imageUrl")val imageUrl: String
)

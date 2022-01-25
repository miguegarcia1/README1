package com.migue.data

import com.google.gson.annotations.SerializedName

data class FilmListResultDto(
    @SerializedName("results") val films:List<FilmDto>
)

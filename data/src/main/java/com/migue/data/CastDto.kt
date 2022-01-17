package com.migue.data

import com.google.gson.annotations.SerializedName

data class CastDto(
    @SerializedName("known_for_departament") val role: String,
    @SerializedName("name") val name : String

)

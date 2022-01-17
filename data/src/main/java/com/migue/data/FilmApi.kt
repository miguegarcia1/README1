package com.migue.data

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


const val API_KEY = "218ef5be18719a35551222f45aa936c5"

interface FilmApi{
    @GET("movie/{id}")
    suspend fun getFilm(@Path("id") filmId : Int,
                        @Query("language") language:String,
                        @Query("apy_key") apiKey:String = API_KEY ): FilmDto



}









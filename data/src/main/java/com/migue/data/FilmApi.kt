package com.migue.data

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


const val API_KEY = "4c2b9b5334ad528ae552837b5e2c340e"
const val BASE_URL= "https://api.themoviedb.org/3/"

interface FilmApi{
    @GET("movie/{id}")
    suspend fun getFilm(@Path("id") filmId : Int,
                        @Query("language") language:String,
                        @Query("apy_key") apiKey:String = API_KEY ): FilmDto


    @GET("movie/{id}/credits")
    suspend fun getCredits (@Path("id") filmId : Int,
                        @Query("apy_key") apiKey:String = API_KEY ): CreditsDto



    @GET("movie/{popular}/")

    suspend fun getPopular
                (@Query("language") language:String,
                 @Query("apy_key") apiKey:String = API_KEY ): FilmListResultDto

}






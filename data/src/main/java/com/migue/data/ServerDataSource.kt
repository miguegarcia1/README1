package com.migue.data

import com.migue.domain.Film
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import usecase.GetFilms
import javax.inject.Inject


class ServerDataSource @Inject constructor() {

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()


    private val api: FilmApi = retrofit.create(FilmApi::class.java)

    suspend fun getFilm(id: Int, language: String): Film {
        val filmDto = api.getFilm(id, language)
        val creditsDto = api.getCredits(id)
        val director = creditsDto.cast.firstOrNull { it.role == "Directing" }?.name ?: ""
        val image = "https://image.tmdb.org/t/p/w500${filmDto.imageUrl}"
        val video =  api.getVideos(id,language).results.filter {
            it.site == "youtube"
        }.firstOrNull {
            it.type == "trailer"
        }?.id

        return Film(filmDto.title, filmDto.id, image, filmDto.name,director, filmDto.description, filmDto.rating,video)


    }

    suspend fun getFilms(language: String): List<Film> {
        return  api.getPopular(language).films.map {
            val image = "https://image.tmdb.org/t/p/w500${it.imageUrl}"
            Film(it.title, it.id, it.imageUrl, it.name,it.description, it.imageUrl, it.rating,null)

        }

    }
}





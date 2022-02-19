package com.migue.data

import com.migue.domain.Film
import database.DatabaseDatasource
import repository.FilmRepository

import javax.inject.Inject

class FilmRepositoryImpl @Inject constructor(
    private val serverDataSource: ServerDataSource ,
    private val databaseDatasource:DatabaseDatasource
): FilmRepository {
    override suspend fun getFilm(id: Int, language: String): Film? {
        return try {
            val filmFromServer = serverDataSource.getFilm(id, language)
            databaseDatasource.clearFilms()
            databaseDatasource.updateFilms(listOf(filmFromServer))
            filmFromServer
        } catch (exception: Exception) {
            databaseDatasource.getFilm(id)
        }
    }


    override suspend fun getFilms(
        language: String
    ): List<Film>? {
    return try {
        val filmsFromServer = serverDataSource.getFilms(language)
        databaseDatasource.updateFilms(filmsFromServer)
        filmsFromServer
    } catch (exception :Exception){
        databaseDatasource.getFilms()
    }

    }




}


















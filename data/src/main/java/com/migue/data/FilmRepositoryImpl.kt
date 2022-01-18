package com.migue.data

import com.migue.domain.Film
import org.intellij.lang.annotations.Language
import repository.FilmRepository
import javax.inject.Inject

class FilmRepositoryImpl @Inject constructor(
    private val serverDataSource: ServerDataSource
): FilmRepository {
    override suspend fun getFilm(id: Int, language: String): Film? {
return runCatching {
serverDataSource.getFilm(id, language)
}.getOrNull()

    }

    override suspend fun getFilms(language: String): List<Film>? {
        TODO("Not yet implemented")
    }
}














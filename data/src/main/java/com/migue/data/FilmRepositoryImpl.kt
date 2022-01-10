package com.migue.data

import com.migue.domain.Film
import repository.FilmRepository
import javax.inject.Inject

class FilmRepositoryImpl @Inject constructor(
    private val dataSource: HardcodedDataSource
): FilmRepository {
    override fun getFilm() :Film{
        return dataSource.getFilm()
    }
}

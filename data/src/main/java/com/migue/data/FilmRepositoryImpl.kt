package com.migue.data

import com.migue.domain.Film
import repository.FilmRepository
import javax.inject.Inject

class FilmRepositoryImpl @Inject constructor() : FilmRepository{
    override fun getFilm() = Film("Batman","" ,"" ,10.0)

}

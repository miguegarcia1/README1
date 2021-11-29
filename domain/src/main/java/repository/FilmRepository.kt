package repository

import com.migue.domain.Film

interface FilmRepository
{
    fun getFilm(): Film
}
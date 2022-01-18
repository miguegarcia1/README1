package repository

import com.migue.domain.Film
import org.intellij.lang.annotations.Language

interface FilmRepository
{
     suspend fun getFilm(id:Int, language:String): Film?
     suspend fun getFilms(language: String):List<Film>?
}
package usecase

import repository.FilmRepository
import javax.inject.Inject
import javax.security.auth.callback.LanguageCallback

class GetFilms @Inject constructor(
    private val repository: FilmRepository
) {
    suspend fun execute(language:String)=repository.getFilms(language)
}
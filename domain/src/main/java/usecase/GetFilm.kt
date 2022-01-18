package usecase

import repository.FilmRepository
import javax.inject.Inject
import javax.security.auth.callback.LanguageCallback

class GetFilm @Inject constructor(
    private val filmRepository : FilmRepository
){
    suspend fun execute (id:Int,language:String) = filmRepository.getFilm(id,language)
}




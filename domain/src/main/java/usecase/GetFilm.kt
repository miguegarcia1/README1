package usecase

import repository.FilmRepository
import javax.inject.Inject

class GetFilm @Inject constructor(
    private val filmRepository : FilmRepository
){
    fun execute () = filmRepository.getFilm()
}




package database

import com.migue.domain.Film
import usecase.GetFilms
import javax.inject.Inject

class DatabaseDatasource  @Inject constructor(
    private val database : AppDatabase
) {
      suspend fun getFilms(): List<Film>{
        return database.filmDao().getFilms().map{it.toDomain()}
    }
      suspend fun getFilm(id:Int): Film?{
        return database.filmDao().getFilm(id)?.toDomain()
}
      suspend fun clearFilms(){

          database.filmDao().deleteAll()
    }
    private  fun FilmEntity.toDomain():Film =
        Film(
            title,
            id,
            imageUrl,
            description,
            director,
            videoId,
            rating,
            director


        )
    suspend fun updateFilms(films: List<Film>){
     database.filmDao().insertAll(films.map { it.toEntity() })
    }

    suspend fun clearFilm (){
        database.filmDao().deleteAll()
    }

    private  fun Film.toEntity() : FilmEntity =
        FilmEntity(
            id,
            title,
            url,
            description,
            rating,
            name,
            videoId


        )


}


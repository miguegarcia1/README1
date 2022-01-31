package List

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.migue.gar.FilmDataView
import kotlinx.coroutines.*
import usecase.GetFilm
import usecase.GetFilms
import java.util.*
import javax.inject.Inject

class FilmViewModel @Inject constructor(
    private val useCase : GetFilms
) :ViewModel(),LifecycleObserver{
    private val filmsLiveData = MutableLiveData<List<FilmOverviewDataView>>()
    val films:LiveData<List<FilmOverviewDataView>> =filmsLiveData
    var job: Job?=null
    fun loadFilms(){
        val language = Locale.getDefault().language

        job= CoroutineScope (Dispatchers.IO).launch{
            val loadedFilms= useCase.execute(language
            )
            withContext(Dispatchers.Main){
                loadedFilms?.let {
                    filmsLiveData.value = it.map{film -> FilmOverviewDataView(film.id,film.title,film.url)}






                }
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }
}
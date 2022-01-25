package List

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.Job
import usecase.GetFilm
import usecase.GetFilms
import javax.inject.Inject

class FilmViewModel @Inject constructor(
    private val useCase : GetFilm
) :ViewModel(),LifecycleObserver{
    var job: Job?=null
    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }
}